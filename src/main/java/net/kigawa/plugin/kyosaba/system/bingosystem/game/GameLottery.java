package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Dropper;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;


public class GameLottery {
    int count=0;
    public Location location;
    public Location location1;
    Material[] materials={
            Material.OBSIDIAN,Material.CRYING_OBSIDIAN,Material.FIRE_CHARGE,
            Material.LEATHER,Material.SOUL_SAND,Material.NETHER_BRICK,
            Material.SPECTRAL_ARROW,Material.GRAVEL,Material.BLACKSTONE
    };
    Material[] materials2={
            Material.ENCHANTED_BOOK,Material.IRON_BOOTS,Material.POTION,
            Material.POTION,Material.SPLASH_POTION,Material.STRING,
            Material.IRON_NUGGET,Material.ENDER_PEARL,Material.QUARTZ
    };
    public GameLottery(Location dropperLoc, Location dropperLoc1){
        location=dropperLoc;
        location1=dropperLoc1;
    }
    public boolean isEnd(){
        return count>=9;
    }
    public  void reset(){
        Dropper dropper=(Dropper) location.getBlock();
        Inventory inventory =dropper.getInventory();
        for (int i=0;i<materials.length;i++) {
            inventory.setItem(i, new ItemStack(materials[i], 1));
        }
        dropper=(Dropper) location1.getBlock();
        inventory=dropper.getInventory();
        for (int i=0;i<materials.length;i++) {
            inventory.setItem(i, new ItemStack(materials2[i], 1));
        }
        inventory.getItem(0).addEnchantment(Enchantment.SOUL_SPEED,3);
        inventory.getItem(1).addEnchantment(Enchantment.SOUL_SPEED,3);
        PotionMeta potionMeta =(PotionMeta) inventory.getItem(3).getItemMeta();
        potionMeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE,true,true));
        potionMeta =(PotionMeta) inventory.getItem(4).getItemMeta();
        potionMeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE,true,true));
    }
    public boolean equals(Object o){
        boolean answer=false;
        if(o instanceof Location){
            if ((this.location.equals(o))){
                answer=true;
            }else {
                if (this.location1.equals(o)){
                    answer=true;
                }
            }
        }
        return answer;
    }
}
