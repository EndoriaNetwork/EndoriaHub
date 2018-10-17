package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.commands.Commands;

public class CommandsManager
{
  public void registers(EndoriaLobby main)
  {
    Commands commands = new Commands();
    EndoriaLobby.getInstance().getCommand("rank").setExecutor(commands);
  }
}
