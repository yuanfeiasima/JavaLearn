package rpc.demo;

import lombok.Data;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/25.
 */
@Data
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

    public ExpResponse(long value, long costInNanos) {
        this.value = value;
        this.costInNanos = costInNanos;
    }
}
