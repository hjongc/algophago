import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10825_국영수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Comparator를 이용한다.
		// 1. 국어 내림차순 
		// 2. 국어가 같으면 영어 오름차순
		// 3. 국어 영어가 같으면 수학 내림차순 
		// 4. 모두 같으면 사전 순으로 오름차순 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Student[] sArr = new Student[N];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			Student student = new Student(name, korean, english, math);
			sArr[i] = student;
		}
		Arrays.sort(sArr, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// 국어 점수 비교 
				if (o1.korean < o2.korean) return 1; // 내림차순
				else if (o1.korean == o2.korean) {
					if (o1.english > o2.english) return 1; // 오름차순? 
//					if (o1.english < o2.english) return -1; // 오름차순? 
					if (o1.english == o2.english) {
						if (o1.math < o2.math) return 1; // 내림차순
						
						else if (o1.math == o2.math) {
							return o1.name.compareTo(o2.name); // 오름차순
						}
						
					}
				}
				return -1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (Student s: sArr) {
			sb.append(s.name).append("\n");
		}
		System.out.println(sb.toString());
	}
	static class Student {
		String name;
		int korean;
		int english;
		int math;
		
		Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math; 
		}

	}
}
