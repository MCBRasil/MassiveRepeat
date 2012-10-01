package com.massivecraft.massiverepeat;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import com.massivecraft.mcore4.util.Perm;

public class RepeatPerm
{
	// -------------------------------------------- //
	// HAS
	// -------------------------------------------- //
	
	public static boolean has(CommandSender sender, String command, boolean verbose)
	{
		if (sender.hasPermission(InternalPermission.REPEAT_STAR.node)) return true;
		Permission permission = getPermissionForCommandCreative(command);
		return Perm.has(sender, permission, verbose);
	}
	
	public static boolean has(CommandSender sender, String command)
	{
		if (sender.hasPermission(InternalPermission.REPEAT_STAR.node)) return true;
		Permission permission = getPermissionForCommandCreative(command);
		return Perm.has(sender, permission);
	}
	
	// -------------------------------------------- //
	// GET PERMISSION
	// -------------------------------------------- //
	
	protected static Permission getPermissionForCommandCreative(String command)
	{
		String name = calcPermissionNameForCommand(command);
		String description = "repeat /"+command;
		Permission permission = Perm.getCreative(name, description, PermissionDefault.OP);
		permission.setDescription("repeat /"+command);
		return permission;
	}
	
	protected static String calcPermissionNameForCommand(String command)
	{
		return "massiverepeat.repeat."+command;
	}
}
