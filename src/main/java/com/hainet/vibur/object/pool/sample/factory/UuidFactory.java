package com.hainet.vibur.object.pool.sample.factory;

import org.vibur.objectpool.PoolObjectFactory;

import java.util.UUID;

public final class UuidFactory implements PoolObjectFactory<UUID> {

    @Override
    public UUID create() {
        UUID uuid = UUID.randomUUID();
        System.out.println("UUID(" + uuid.toString() + ") is created.");
        return uuid;
    }

    @Override
    public boolean readyToTake(final UUID uuid) {
        return true;
    }

    @Override
    public boolean readyToRestore(final UUID uuid) {
        return true;
    }

    @Override
    public void destroy(final UUID uuid) {
        // do nothing
    }
}
