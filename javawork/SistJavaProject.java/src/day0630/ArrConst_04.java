package day0630;

abstract class Game{
	
	abstract void play();
	abstract void stop();
}
/////////////////////////////////////////////
class SungHyeon extends Game{

	@Override
	void play() {
		System.out.println("성현이가 게임을 시작합니다");
		
	}

	@Override
	void stop() {
		System.out.println("성현이가 게임을 종료합니다");
		
	}	
	
}
////////////////////////////////////////////
class SoonYeong extends Game{

	@Override
	void play() {
		System.out.println("순영이가 게임을 시작합니다");
		
	}

	@Override
	void stop() {
		System.out.println("순영이가 게임을 종료합니다");
		
	}	
	
}
//////////////////////////////////////////////
class SunBum extends Game{

	@Override
	void play() {
		
		System.out.println("선범이가 게임을 시작합니다");
	}

	@Override
	void stop() {
		
		System.out.println("선범이가 게임을 종료합니다");
	}	
	
}
//////////////////////////////////////////////
public class ArrConst_04 {

	public static void main(String[] args) {
		
		//배열선언
		Game[] game  = new Game[3];
		
		//각각의 sub로 생성
		game[0]=new SungHyeon();
		game[1]=new SoonYeong();
		game[2]=new SunBum();
		
		//for(증가)
		for(int i=0; i<game.length ; i++) {
			game[i].play();
		}
		System.out.println("--------------------------------");
		//for(감소)
		for(int i=game.length-1; i>=0 ; i--) {
			game[i].stop();
		}
		
	}

}
//성현이가 게임을합니다
//순영이가 게임을합니다
//선범이가 게임을 합니다
//-----------------------
//선범이가 게임을 종료합니다
//순영이가 게임을 종료합니다
//성현이가 게임을 종료합니다