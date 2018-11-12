package rpc.demo;

import lombok.Data;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/25.
 */
@Data
public class ExpRequest {
    private int base;
    private int exp;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
