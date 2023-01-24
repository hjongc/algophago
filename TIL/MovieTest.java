public class MovieTest {
	public static void main(String[] args) {
		// 2개의 영화 생성
		// 기본 생성자로 만든 '나홀로집에' type : Movie
		Movie HomeAlone = new Movie();
		HomeAlone.setId(2023);
		HomeAlone.setTitle("HomeAlone");
		HomeAlone.setDirector("Chris Columbus");
		HomeAlone.setGenre("Comedy");
		HomeAlone.setRunningTime(103);
		// 인자를 줘서 만든 '이웃집 토토로' type : Movie
		Movie Totoro = new Movie(1988, "My Neighbor Totoro", "Miyazaki Hayao", "Animation", 88);
		
		// 잘 생성되었는지 확인하기 위한 출력
		System.out.println(HomeAlone.toString());
		System.out.println(Totoro.toString());
		System.out.println("-------------");
		
		/************************************************************
		 *  non - static 제한자로 구현된 add와 getList 메소드 실행
		 *************************************************************/
		MovieManager MvManager = MovieManager.getInstance(); // 인스턴스 생성
		MvManager.add(HomeAlone); // add
		MvManager.add(Totoro);
		Movie[] MovieList = MvManager.getList(); // getList 후 출력
		for (int i = 0; MovieList[i] != null; i++) {
			System.out.printf("#%d movie in List = "+MovieList[i].getTitle()+"\n",i);
		}
		
//		/************************************************************
//		 *  static 제한자로 구현된 add와 getList 메소드 실행
//		 *************************************************************/
//		MovieManager.add(HomeAlone); // add
//		MovieManager.add(Totoro);
		// getList 후 결과 출력
//		for (int i = 0; MovieManager.getInstance().getList()[i] != null; i++) {
//			System.out.printf("#%d movie in List = "+MovieManager.getInstance().getList()[i].getTitle()+"\n",i);
//		}
		
		
		// 영화 제목으로 영화 검색
		System.out.println("-------------");
		MovieManager.searchByTitle("HomeAlone"); // 이미 존재하는 영화1
		System.out.println("-------------");
		MovieManager.searchByTitle("My Neighbor Totoro"); // 이미 존재하는 영화2
		System.out.println("-------------");
		MovieManager.searchByTitle("HomeAlone2"); // 존재하지 않는 영화
	}
}


