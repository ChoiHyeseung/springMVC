//다른 곳에서도 사용해야하므로 basic 패키지에 만듦
package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HelloData {
    private String username;
    private int age;

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
    //롬복을 설치했으므로 어노테이션으로 getter setter를 굳이 안적어됨

}

