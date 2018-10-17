package fr.hugob147.endorialobby.rank;

import fr.hugob147.endorialobby.mysql.MySQL;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rank
{
	public void createAccount(Player p)
	{
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement(
					"SELECT `grade` FROM `rank` WHERE `player_uuid`='" + p.getUniqueId().toString() + "'");
			ResultSet rs = sts.executeQuery();
			if (!rs.next())
			{
				sts.close();
				sts = MySQL.getConnection().prepareStatement(
						"INSERT INTO `rank` (player_uuid, grade) VALUES ('" + p.getUniqueId().toString() + "', '" + RankUnit.Joueur.getPower() + "')");
				sts.executeUpdate();
				sts.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public RankUnit getRank(Player p)
	{
		RankUnit rank = null;
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement(
					"SELECT `grade` FROM `rank` WHERE `player_uuid`='" + p.getUniqueId().toString() + "'");
			ResultSet rs = sts.executeQuery();
			if (rs.next())
			{
				rank = RankUnit.getFromPower(rs.getInt("grade"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rank;
	}

	public void setRank(Player p, RankUnit rank)
	{
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement(
					"UPDATE `rank` SET `grade`='" + rank.getPower() + "' WHERE `player_uuid`='" + p.getUniqueId().toString() + "'");
			sts.executeUpdate();
			sts.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public boolean hasPermission(Player p, String permission)
	{
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement(
					"SELECT `permission` FROM `permissions` WHERE `player_uuid`='" + p.getUniqueId().toString() + "' and `permission`='" + permission + "'");
			ResultSet rs = sts.executeQuery();
			if ((rs.next()) && (permission.equals(rs.getString("permission"))))
			{
				return true;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public void addPermission(Player p, String permission)
	{
		if (hasPermission(p, permission))
		{
			return;
		}
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement(
					"INSERT INTO `permissions` (player_uuid, permission) VALUES ('" + p.getUniqueId().toString() + "', '" + permission + "')");
			Throwable localThrowable3 = null;
			try
			{
				sts.executeUpdate();
			} catch (Throwable localThrowable1)
			{
				localThrowable3 = localThrowable1;
				throw localThrowable1;
			} finally
			{
				if (sts != null)
				{
					if (localThrowable3 != null)
					{
						try
						{
							sts.close();
						} catch (Throwable localThrowable2)
						{
							localThrowable3.addSuppressed(localThrowable2);
						}
					} else
					{
						sts.close();
					}
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void removePermission(Player p, String permission)
	{
		if (!hasPermission(p, permission))
		{
			return;
		}
		try
		{
			PreparedStatement sts = MySQL.getConnection().prepareStatement(
					"DELETE FROM `permissions` WHERE `player_uuid`='" + p.getUniqueId().toString() + "' and `permission`='" + permission + "'");
			sts.executeUpdate();
			sts.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
