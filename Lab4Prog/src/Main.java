import Classes.Control;
import Classes.Team;
import Classes.Characters.*;
import Classes.Characters.Character;
import Classes.Locations.*;
import Enums.Feelings;
import Enums.MiniLocations;
import Enums.Weather;
import Exceptions.CookiesEatingException;
import Records.HiderData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// * Variant 6578567

// ? UML-диаграмма 
// * Методы через нейросеть - сравнение
// * Запуск на helios
// * Отчёт
// * Экспорт на ГитХаб
// * Теория

public class Main {
    public static void main(String[] args) throws CookiesEatingException {
        ChrisRobin chrisRobin;
        Hrunya hrunya;
        Ia ia;
        Tigrulya tigrulya;
        WinniePooh winniePooh;
        Zhavoronok zhavoronok;

        try {
            chrisRobin  = new ChrisRobin("Кристофер Робин", 10, 2);
            hrunya      = new Hrunya("Хрюня", 10, 4);
            ia          = new Ia("Иа", 10, 2);
            tigrulya    = new Tigrulya("Тигруля", 10, 2);
            winniePooh  = new WinniePooh("Винни-Пух", 10, 2);
            zhavoronok  = new Zhavoronok("Жаворонок", 10, 2);
        } catch (CookiesEatingException error) {
            System.err.println(error.getMessage() + "\n\n");

            chrisRobin  = new ChrisRobin("Кристофер Робин", 10, 2);
            hrunya      = new Hrunya("Хрюня", 10, 4);
            ia          = new Ia("Иа", 10, 2);
            tigrulya    = new Tigrulya("Тигруля", 10, 2);
            winniePooh  = new WinniePooh("Винни-Пух", 10, 2);
            zhavoronok  = new Zhavoronok("Жаворонок", 10, 2);
        }

        Forest      forest      = new Forest("Лес");
        Hill        hill        = new Hill("Холм");
        GloomyPlace gloomyPlace = new GloomyPlace("Глухое место");
        Home        home        = new Home("Дом Кристофера Робина");

        Control.setLocations(new ArrayList<>(Arrays.asList(forest, hill, gloomyPlace, home)));

        ArrayList<Character> characterList = new ArrayList<>(Arrays.asList(
            chrisRobin,
            hrunya,
            ia,
            tigrulya,
            winniePooh,
            zhavoronok
        ));

        Character hiderCharacter = characterList.get(Control.RANDOM.nextInt(characterList.size()));
        characterList.remove(hiderCharacter);
        characterList.remove(Control.RANDOM.nextInt(characterList.size()));
        
        Team seekers = new Team(characterList);

        ArrayList<Location> allLocationList = Control.getLocationList();
        Location hiderLocation = allLocationList.get(Control.RANDOM.nextInt(Control.getLocationList().size()));
        ArrayList<MiniLocations> currentAllMiniLocations = hiderLocation.getLocationList();
        MiniLocations hiderMiniLocation = currentAllMiniLocations.get(Control.RANDOM.nextInt(currentAllMiniLocations.size()));

        hiderCharacter.setCurrentLocation(
            hiderLocation,
            hiderMiniLocation
        );

        HiderData hiderData = new HiderData(
            hiderCharacter.getName(),
            hiderLocation,
            hiderMiniLocation
        );

        // Начинаем историю:

        Control.addSentence(hiderData.hiderName() + " потерялся");
        Control.addSentence(seekers.getMembersString() + " отправились искать " + hiderData.hiderName());

        Collections.shuffle(allLocationList);

        outer:
        for (Location location : allLocationList) {
           
            location.setWeather(Weather.getRandomWeather());
            location.setFeeling(Feelings.getRandomFeeling());

            Control.addSentence(String.format("%s. Была %s.\nВдруг резко стало %s", 
                location.getName(),
                location.getWeatherText(),
                location.getFeelingDescription()
            ));

            for (MiniLocations currentLocation : location.getLocationList()) {
                seekers.setMembersCurrentLocation(location, currentLocation);
                Control.addSentence("Персонажи пришли на " + currentLocation.getDescription());

                Character currentActivePerson = seekers.getRandomMember();
                Control.addSentence(currentActivePerson.getName() + " закричал \"" + currentActivePerson.makeSound(hiderCharacter) + "\"");

                if ( currentLocation == hiderData.hiderMiniLocation() ) {
                    if (seekers.getMembersCount() == 1) {
                        Control.addSentence(hiderData.hiderName() + " " + hiderCharacter.makeAction() + "\n" + seekers.getMembersString() + " нашёл потеряшку!\nОни пошли пить чай с печеньками");
                    } else {
                        Control.addSentence(hiderData.hiderName() + " " + hiderCharacter.makeAction() + "\n" + seekers.getMembersString() + " нашли потеряшку!\nОни пошли пить чай с печеньками");
                    }
                    break outer;
                } else {
                    seekers.checkMembers();

                    if (seekers.getMemberList().size() == 0) {
                        Control.addSentence("К сожалению, все персонажи устали и ушли домой(\nПотеряшка сегодня останется в " + hiderData.hiderLocation().getName() + " на " + hiderData.hiderMiniLocation().getDescription());
                        break outer;
                    } else {
                        Control.addSentence("К сожалению, на " + currentLocation.getDescription() + " " + hiderData.hiderName() + " не оказалось\nГерои отправились дальше...");
                    }
                }
            }
        }

        for (String sentence : Control.getResultText()) {
            System.out.println(sentence);
        }

    }
}