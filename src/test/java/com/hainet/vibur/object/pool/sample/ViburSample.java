package com.hainet.vibur.object.pool.sample;

import com.hainet.vibur.object.pool.sample.factory.UuidFactory;
import com.hainet.vibur.object.pool.sample.listener.UuidListener;
import org.junit.Test;
import org.vibur.objectpool.ConcurrentPool;
import org.vibur.objectpool.PoolService;
import org.vibur.objectpool.util.ConcurrentLinkedDequeCollection;

import java.util.UUID;

public class ViburSample {

    @Test
    public void test() {
        final PoolService<UUID> pool = new ConcurrentPool<>(
                new ConcurrentLinkedDequeCollection<>(),
                new UuidFactory(),
                2,
                3,
                false,
                new UuidListener()
        );

        // Pool生成時に生成した値を取得
        pool.take();
        pool.take();

        // 起動時に生成した値が存在しないため、
        // UuidFactory#create()を経由して値を取得
        pool.take();

        // restoreした値を取得
        pool.restore(UUID.randomUUID());
        pool.take();

        pool.terminate();
    }
}
