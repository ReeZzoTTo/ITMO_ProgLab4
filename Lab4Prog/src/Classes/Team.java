package Classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import Classes.Characters.Character;
import Enums.MiniLocations;;

public class Team {
    private ArrayList<Character> members;

    public Team(ArrayList<Character> members) {
        try {
            this.members = Objects.requireNonNull(members);
        } catch (NullPointerException e) {
            System.out.println("Команда не может быть создана, так как список участников пуст");
            this.members = new ArrayList<>();
        }
    }


    public ArrayList<Character> getMemberList() {
        return this.members;
    }

    public void setMemberList(ArrayList<Character> memberList) {
        this.members = memberList;
    }

    public void addMembers(Character[] args) {
        for (Character member : args) {
            members.add(member);
        }
    }

    public void addMember(Character member) {
        this.members.add(member);
    }

    public void deleteMember(Character member) {
        this.members.remove(member);
    }

    public Character getRandomMember() {
        return this.members.get(Control.RANDOM.nextInt(this.members.size()));
    }

    public int getMembersCount() {
        return this.members.size();
    }

    public String getMembersString() {
        String currentSentence = "";

        for (Character person : this.members) {
            if (currentSentence.length() != 0) { currentSentence += ", " + person.getName(); }
            else { currentSentence += person.getName(); }
        }
        return currentSentence;
    }

    public void checkMembers() {
        for (Character member : this.members) {
            member.eat(member.currentLocation());
        }
        Control.addSentence("Все скушали печенье");

        Iterator<Character> iterator = this.members.iterator();

        while (iterator.hasNext()) {
            Character member = iterator.next();

            if (member.getCookiesCount() <= 0) {
                Control.addSentence(member.getName() + " сильно проголодался, устал и ушёл домой");
                iterator.remove();
            }
        }
    }

    public void setMembersCurrentLocation(Location location, MiniLocations miniLocation) {
        for (Character member : this.members) {
            member.setCurrentLocation(location, miniLocation);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team team)) return false;
        return Objects.equals(new HashSet<>(members), new HashSet<>(team.members));
    }

    @Override
    public int hashCode() {
        return new HashSet<>(members).hashCode();
    }

    @Override
    public String toString() {
        return "Team{" +
            "members=" + members +
            ", membersCount=" + members.size() +
            '}';
    }
}
