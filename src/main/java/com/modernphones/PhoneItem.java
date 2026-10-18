package com.modernphones;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PhoneItem extends Item {
    private final String phoneName;

    public PhoneItem(Properties properties, String phoneName) {
        super(properties);
        this.phoneName = phoneName;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            long dayTime = (level.getDayTime() + 6000L) % 24000L; // 0 = 00:00 in-game
            int hours = (int) (dayTime / 1000L);
            int minutes = (int) ((dayTime % 1000L) * 60L / 1000L);
            String game = String.format("%02d:%02d", hours, minutes);
            String real = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
            player.displayClientMessage(Component.literal(String.format(
                    "§b%s §7| §eOyun %s §7| §aGercek %s §7| §fXYZ %d %d %d",
                    phoneName, game, real, player.getBlockX(), player.getBlockY(), player.getBlockZ())), true);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
