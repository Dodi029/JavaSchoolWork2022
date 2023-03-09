// 메소드 오버라이딩으로 다형성 실현 
// 게임에서 무기를 표현하는 Weapon 클래스를 만들고 살상 능력을 리턴하는 fire() 메소드를 작성함

class Weapon {
	protected int fire() {
		return 1;
	}
}

// 대포를 구현하기 위해 Weapon을 상속받는 Cannon 클래스를 작성하라. 
// Cannon은 살상 능력이 10이다. fire() 메소드를 이에 맞게 오버라이딩하라. 
// main을 작성하여 오버라이딩을 테스트하라. 

class Cannon extends Weapon {
	
	protected int fire() {
		return 10;
	}
}

public class Overriding {
	public static void main(String[] args) {
		Weapon weapon;
		
		weapon = new Weapon();
		System.out.println(" 기본 무기의 살상 능력은 " + weapon.fire());
		
		weapon = new Cannon();
		System.out.println(" 대포의 살상 능력은 " + weapon.fire());
	}
}
