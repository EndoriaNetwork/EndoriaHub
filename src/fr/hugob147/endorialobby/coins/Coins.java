package fr.hugob147.endorialobby.coins;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.mysql.MySQL;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Coins
{
	public void createAccount(Player player, Double coins)
	{
		try
		{
			PreparedStatement sts = EndoriaLobby.getInstance().mysql.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
			sts.setString(1, player.getUniqueId().toString());
			ResultSet rs = sts.executeQuery();
			if (!rs.next())
			{
				sts.close();
				sts = EndoriaLobby.getInstance().mysql.getConnection().prepareStatement("INSERT INTO coins (player_uuid, coins) VALUES (?, ?)");
				sts.setString(1, player.getUniqueId().toString());
				sts.setDouble(2, coins);
				sts.executeUpdate();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Double getCoins(Player player)
	{
		try
		{
			PreparedStatement sts = EndoriaLobby.getInstance().mysql.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
			sts.setString(1, player.getUniqueId().toString());
			ResultSet rs = sts.executeQuery();
			if (rs.next())
			{
				return rs.getDouble("coins");
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0D;
	}

	public void addCoins(Player player, Double coins)
	{
		if (coins < 1L)
		{
			return;
		}
		try
		{
			PreparedStatement sts = EndoriaLobby.getInstance().mysql.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
			sts.setString(1, player.getUniqueId().toString());
			ResultSet rs = sts.executeQuery();
			if (rs.next())
			{
				Double money = rs.getDouble("coins");
				sts.close();
				sts = EndoriaLobby.getInstance().mysql.getConnection().prepareStatement("UPDATE coins SET coins=? WHERE player_uuid=?");
				sts.setDouble(1, coins + money);
				sts.setString(2, player.getUniqueId().toString());
				sts.executeUpdate();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void removeCoins(Player player, Double coins)
	{
		if (coins < 1L)
		{
			return;
		}
		try
		{
			PreparedStatement sts = EndoriaLobby.getInstance().mysql.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
			sts.setString(1, player.getUniqueId().toString());
			ResultSet rs = sts.executeQuery();
			if (rs.next())
			{
				Double money = rs.getDouble("coins");
				sts.close();
				if (money - coins < 0L)
				{
					coins = money;
				}
				sts = EndoriaLobby.getInstance().mysql.getConnection().prepareStatement("UPDATE coins SET coins=? WHERE player_uuid=?");
				sts.setDouble(1, money - coins);
				sts.setString(2, player.getUniqueId().toString());
				sts.executeUpdate();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
