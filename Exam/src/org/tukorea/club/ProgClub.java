package org.tukorea.club;

import java.util.*;

class ProgClubIterator implements Iterator{
	private ProgClub club;
	private int index;
	public ProgClubIterator(ProgClub club) {this.club = club;}
	public boolean hasNext() {
		if(index == club.memberList.size())
			return false;
		return true;
	}
	public Object next() {
		ProgClubMember member = club.memberList.get(index);
		++index;
		return member;
	}
}

public class ProgClub implements Aggregate {
	ArrayList<ProgClubMember> memberList;
	public ProgClub() {memberList = new ArrayList<ProgClubMember>();}
	public Iterator createIterator() {
		return new ProgClubIterator(this);
	}
	public void addMember(ProgClubMember progClubMember) {
		// TODO Auto-generated method stub
		memberList.add(progClubMember);
	}
} 
