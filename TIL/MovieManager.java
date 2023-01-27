/**
 * 영화리스트를 배열로 관리하는 클래스
 */
public class MovieManager {
	
	private final int MAX_SIZE = 100; // final : 더 이상 고칠 수 업는 상수
	
	private Movie[] movieList = new Movie[MAX_SIZE];
	
	private int size = 0;
	//싱글턴
	//private로 자기자신 인스턴스 만들기
	//외부에서 생성하지 못하도록 private로 막기
	//유일한 인스턴스에 접근 가능한 getter 만들기
	/************************************************************
	 * Static과 non - Static 두 가지 방법 add와 getList 함수 작성
	 * MovieManager.java와 MovieTest.java에서 하나의 방식으로 통일하여
	 * 주석을 풀거나 해제해 주면 됨
	 ************************************************************/
	/************************************************************
	 *  non - static 제한자로 구현된 add와 getList 메소드
	 *************************************************************/
	public void add(Movie movie) {
		this.movieList[this.size] = movie;
		this.size++;
	}
	public Movie[] getList() {
		return this.movieList;
	}
	
//	/************************************************************
//	 *  static 제한자로 구현된 add와 getList 메소드
//	 *************************************************************/
//	public static void add(Movie movie) {
//		MovieManager.getInstance().movieList[MovieManager.getInstance().size] = movie;
//		MovieManager.getInstance().size++;
//	}
//	public static Movie[] getList() {
//		return MovieManager.getInstance().movieList;
//	}
	// 이름으로 영화 찾기
	public static Movie searchByTitle(String title) {
		for (int i = 0; i<instance.size; i++) {
			if (MovieManager.getInstance().movieList[i].getTitle().equals(title)) {
				System.out.println("id = "+MovieManager.getInstance().movieList[i].getId());
				System.out.println("Title = "+MovieManager.getInstance().movieList[i].getTitle());
				System.out.println("Director = "+MovieManager.getInstance().movieList[i].getDirector());
				System.out.println("Genre = "+MovieManager.getInstance().movieList[i].getGenre());
				System.out.println("RunningTime = "+MovieManager.getInstance().movieList[i].getRunningTime());
				
				return MovieManager.getInstance().movieList[i];}
		}
		// 만약 찾기 못한 경우 다른 영화를 추천해주면서 해당 영화가 존재하지 않는다고 알려줌
		System.out.println("해당하는 영화가 존재하지 않습니다"); 
		if (instance.size > 0) {
			System.out.printf("이런 영화는 어떤가요? -> ");
			System.out.println(MovieManager.getInstance().movieList[0].getTitle());
		}
		return MovieManager.getInstance().movieList[0];
	}

	// 싱글톤
	private static MovieManager instance = new MovieManager();
	
	private MovieManager() {
	}
	public static MovieManager getInstance() {
		return instance;
	}
}

