package org.tukorea.center;

import org.tukorea.club.*;

public class StudentCenter {
	public static void main(String[] args) {
		ProgClub club = new ProgClub();
		club.addMember(new ProgClubMember("철수", "1201", "소프트웨어", "파이썬", "남성"));
		club.addMember(new ProgClubMember("영숙", "1202", "컴퓨터", "C++", "여성"));
		club.addMember(new ProgClubMember("미희", "2401", "IT경영", "자바", "여성"));
		club.addMember(new ProgClubMember("길동", "2402", "전자", "C", "남성"));
		System.out.println("프로그래밍 동아리 회원을 출력합니다.");
		Iterator it = club.createIterator();
		
		while(it.hasNext()) {
			ProgClubMember member = (ProgClubMember) it.next();
			System.out.println(member.toString());
		}
	}
}
