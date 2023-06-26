package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//동시성 문제가 고려되어 있지 않음. 실무에서는 ConcurrentHashMap, AtomicLong 사용고려
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;  // id 값

    private static  MemberRepository instance = new MemberRepository(); // 싱글톤

    public static MemberRepository getInstance(){
        return instance;
    }
    // 아무나 생성 못하게 private으로
    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        // arraylist를 조작해도 store의 값을 건들고 싶지 않기 때문에 별도로 새로 만들어 조회한다.
        return new ArrayList<>(store.values());
    }

    // 테스트 코드에서만 사용
    public void clearStore(){
        store.clear();
    }
}
