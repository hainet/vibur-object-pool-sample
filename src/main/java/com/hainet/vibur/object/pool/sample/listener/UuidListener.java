package com.hainet.vibur.object.pool.sample.listener;

import org.vibur.objectpool.util.TakenListener;

import java.util.UUID;

public final class UuidListener extends TakenListener<UUID> {

    @Override
    public void onTake(final UUID uuid) {
        System.out.println("UUID(" + uuid.toString() + ") is taken.");
        super.onTake(uuid);
    }

    @Override
    public void onRestore(final UUID uuid) {
        System.out.println("UUID(" + uuid.toString() + ") is restored.");
        super.onRestore(uuid);
    }
}
