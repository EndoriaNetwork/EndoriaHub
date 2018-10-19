package fr.hugob147.endorialobby.coins;

import fr.hugob147.endorialobby.mysql.MySQL;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Coins
{
	public void createAccount(Player player, long coins)
	{
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
			sts.setString(1, player.getUniqueId().toString());
			ResultSet rs = sts.executeQuery();
			if (!rs.next())
			{
				sts.close();
				sts = MySQL.getConnection().prepareStatement("INSERT INTO coins (player_uuid, coins) VALUES (?, ?)");
				sts.setString(1, player.getUniqueId().toString());
				sts.setLong(2, coins);
				sts.executeUpdate();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public long getCoins(Player player)
	{
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
			sts.setString(1, player.getUniqueId().toString());
			ResultSet rs = sts.executeQuery();
			if (rs.next())
			{
				return rs.getLong("coins");
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0L;
	}

	public void addCoins(Player player, long coins)
	{
		if (coins < 1L)
		{
			return;
		}
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
			sts.setString(1, player.getUniqueId().toString());
			ResultSet rs = sts.executeQuery();
			if (rs.next())
			{
				long money = rs.getLong("coins");
				sts.close();
				sts = MySQL.getConnection().prepareStatement("UPDATE coins SET coins=? WHERE player_uuid=?");
				sts.setLong(1, coins + money);
				sts.setString(2, player.getUniqueId().toString());
				sts.executeUpdate();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void removeCoins(Player player, long coins)
	{
		if (coins < 1L)
		{
			return;
		}
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
			sts.setString(1, player.getUniqueId().toString());
			ResultSet rs = sts.executeQuery();
			if (rs.next())
			{
				long money = rs.getLong("coins");
				sts.close();
				if (money - coins < 0L)
				{
					coins = money;
				}
				sts = MySQL.getConnection().prepareStatement("UPDATE coins SET coins=? WHERE player_uuid=?");
				sts.setLong(1, money - coins);
				sts.setString(2, player.getUniqueId().toString());
				sts.executeUpdate();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
