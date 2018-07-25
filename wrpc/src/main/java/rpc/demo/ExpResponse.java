package rpc.demo;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/25.
 */
public class ExpResponse {
    private long value;
    private long costInNanos;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getCostInNanos() {
        return costInNanos;
    }

    public void setCostInNanos(long costInNanos) {
        this.costInNanos = costInNanos;
    }
}
