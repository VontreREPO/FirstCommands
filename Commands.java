package com.vontre.commands.main;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        // Make sure sender's a player (not console)
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
        }

        // Actual Command
        if (cmd.getName().equalsIgnoreCase("kit")) {
            // Converting Byte to String
            byte KitNumber = Byte.parseByte(args[0]);

            // Declaring the player
            Player player = (Player) sender;

            // Custom Bow
            ItemStack ArcherBow = new ItemStack(Material.BOW);
            ArcherBow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
            ArcherBow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
            ArcherBow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);

            // Checking the kit to be chosen.
            switch (KitNumber) {
                case 1:
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    player.getInventory().addItem(new ItemStack(Material.FISHING_ROD));
                    player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 5));
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS));
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS));
                    break;
                case 2:
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 5));
                    player.getInventory().addItem(ArcherBow);
                    player.getInventory().addItem(new ItemStack(Material.LEATHER_HELMET));
                    player.getInventory().addItem(new ItemStack(Material.LEATHER_CHESTPLATE));
                    player.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS));
                    player.getInventory().addItem(new ItemStack(Material.LEATHER_BOOTS));
                    break;
                // No new kit ideas for now.
            }

        }

        return true;
    }
}
