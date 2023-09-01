package home.amit.service.searchservice.osttra;
/*
User :- AmitSingh
Date :- 9/1/2023
Time :- 11:45 AM
Year :- 2023
*/


public class UserAction implements Comparable<UserAction>{

    private String userId;
    private String action;


    public UserAction(String userId, String action) {
        this.userId = userId;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "UserAction{" +
                "userId='" + userId + '\'' +
                ", action='" + action + '\'' +
                '}';
    }


    @Override
    public int compareTo(UserAction obj2) {
        if (this.userId.compareTo(obj2.userId) ==0)
        {
          return this.userId.compareTo(obj2.action);
        };
        return -1;
    }
}
