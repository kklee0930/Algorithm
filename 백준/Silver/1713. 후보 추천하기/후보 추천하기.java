import java.util.*;
import java.io.*;

class Main {
    static class Candidate {
        int number;
        int time;
        int voteCnt;
        boolean isPosted;

        public Candidate(int number, int time, int voteCnt, boolean isPosted) {
            this.number = number; // 학생번호
            this.time = time; // 추천 시점
            this.voteCnt = voteCnt; // 추천 횟수
            this.isPosted = isPosted; // 후보 여부
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 사진틀의 갯수
        int cnt = Integer.parseInt(br.readLine()); // 추천 횟수
        
        List<Candidate> candidateList = new ArrayList<>();
        Candidate[] candidates = new Candidate[101];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cnt; i++) {
            int vote = Integer.parseInt(st.nextToken());

            // 학생이 처음 추천받는 경우
            if(candidates[vote] == null) {
                 candidates[vote] = new Candidate(vote, 0, 0, false);
            }
            // 이미 게시된 학생인 경우
            if(candidates[vote].isPosted) {
                candidates[vote].voteCnt++;
            }
            else { // 게시된 적이 없는 학생인 경우
                // 게시판에 자리가 없는 경우 게시판의 학생 투표 수, 추천 시점 순으로 내림차순 정렬
                if(candidateList.size() == N) {
                    Collections.sort(candidateList, new Comparator<Candidate>() {
                        public int compare(Candidate o1, Candidate o2) {
                            if(o1.voteCnt == o2.voteCnt) {
                                return o1.time - o2.time;
                            }
                            return o1.voteCnt - o2.voteCnt;
                        }
                    });
                    // 삭제 처리
                    candidateList.get(0).isPosted = false;
                    candidateList.remove(0);
                }
                candidates[vote].voteCnt = 1;
                candidates[vote].time = i;
                candidates[vote].isPosted = true;
                candidateList.add(candidates[vote]);
            }
        }
        br.close();

        Collections.sort(candidateList, (o1, o2) -> o1.number - o2.number);
        for(Candidate candidate : candidateList) {
            bw.write(candidate.number + " ");
        }
        bw.flush();
        bw.close();
    }
}