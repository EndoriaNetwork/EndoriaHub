package fr.hugob147.endorialobby.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class ItemBuilder
{
	private ItemStack is;

	public ItemBuilder(Material m)
	{
		this(m, 1);
	}

	public ItemBuilder(ItemStack is)
	{
		this.is = is;
	}

	public ItemBuilder(Material m, int amount)
	{
		this.is = new ItemStack(m, amount);
	}

	public ItemBuilder(Material m, int amount, short meta)
	{
		this.is = new ItemStack(m, amount, meta);
	}

	public ItemBuilder clone()
	{
		return new ItemBuilder(this.is);
	}

	public ItemBuilder setDurability(short dur)
	{
		this.is.setDurability(dur);
		return this;
	}

	public ItemBuilder setName(String name)
	{
		ItemMeta im = this.is.getItemMeta();
		im.setDisplayName(name);
		this.is.setItemMeta(im);
		return this;
	}

	public ItemBuilder addUnsafeEnchantment(Enchantment ench, int level)
	{
		this.is.addUnsafeEnchantment(ench, level);
		return this;
	}

	public ItemBuilder removeEnchantment(Enchantment ench)
	{
		this.is.removeEnchantment(ench);
		return this;
	}

	public ItemBuilder setSkullOwner(String owner)
	{
		try
		{
			SkullMeta im = (SkullMeta) this.is.getItemMeta();
			im.setOwner(owner);
			this.is.setItemMeta(im);
		} catch (ClassCastException localClassCastException)
		{
		}
		return this;
	}

	public ItemBuilder setSkullUrl(String url)
	{
		is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

		if (url == null || url.isEmpty())
			return this;

		ItemMeta skullMeta = is.getItemMeta();
		GameProfile profile = new GameProfile(UUID.randomUUID(), null);
		byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
		profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
		Field profileField = null;

		try {
			profileField = skullMeta.getClass().getDeclaredField("profile");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		profileField.setAccessible(true);

		try {
			profileField.set(skullMeta, profile);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		is.setItemMeta(skullMeta);
		return this;
	}

	public ItemBuilder addEnchant(Enchantment ench, int level)
	{
		ItemMeta im = this.is.getItemMeta();
		im.addEnchant(ench, level, true);
		this.is.setItemMeta(im);
		return this;
	}

	public ItemBuilder setInfinityDurability()
	{
		this.is.setDurability((short) Short.MAX_VALUE);
		return this;
	}

	public ItemBuilder setLore(String... lore)
	{
		ItemMeta im = this.is.getItemMeta();
		im.setLore(Arrays.asList(lore));
		this.is.setItemMeta(im);
		return this;
	}

	public ItemBuilder setGlassPaneColor(DyeColor color)
	{
		if (!this.is.getType().equals(Material.STAINED_GLASS_PANE))
		{
			return this;
		}
		this.is.setDurability(color.getData());
		return this;
	}

	public ItemBuilder setWoolColor(DyeColor color)
	{
		if (!is.getType().equals(Material.WOOL))
			return this;
		this.is.setDurability(color.getData());
		return this;
	}

	public ItemBuilder setClayColor(DyeColor color)
	{
		if (!this.is.getType().equals(Material.STAINED_CLAY))
		{
			return this;
		}
		this.is.setDurability(color.getData());
		return this;
	}

	public ItemBuilder setLeatherArmorColor(Color color)
	{
		try
		{
			LeatherArmorMeta im = (LeatherArmorMeta) this.is.getItemMeta();
			im.setColor(color);
			this.is.setItemMeta(im);
		} catch (ClassCastException localClassCastException)
		{
		}
		return this;
	}

	public ItemStack toItemStack()
	{
		return this.is;
	}
}
