package spring.boot.com.elasticSearch.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/2/28
 * @description: 分词数组
 */
public class RequestBody {
    private List<UserModel> tokens = new ArrayList<>();

    public List<UserModel> getTokens() {
        return tokens;
    }

    public void setTokens(List<UserModel> tokens) {
        this.tokens = tokens;
    }
}
