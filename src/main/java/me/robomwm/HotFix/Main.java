package me.robomwm.HotFix;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Robo on 2/12/2016.
 */
public class Main extends JavaPlugin implements Listener {
    boolean herp = false;
    boolean schedule = false;

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        //getServer().getMessenger().registerOutgoingPluginChannel(this, "MC|BOpen");
    }

    @Override
    public void onDisable() {
        if (waxTask != null) {
            try { waxTask.cancel(); } catch (Exception ignored) {}
            waxTask = null;
        }
    }



    //@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
//    void onEntityDerp(EntityDamageByEntityEvent event) {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(event.getEntityType().toString() + " Damages for " + String.valueOf(event.getFinalDamage()));
//    }

    //@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
//    void blep(EntityExplodeEvent event) {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(String.valueOf(event.blockList().size()));
//        Bukkit.broadcastMessage(String.valueOf(event.getYield()));
//    }

//    //@EventHandler
//    void derp(EntityChangeBlockEvent event) {
//        if (herp) {
//            if (event.getTo() == Material.AIR) {
//                return;
//            }
//            FallingBlock entity = (FallingBlock) event.getEntity();
//            Block block = event.getBlock();
//            Bukkit.broadcastMessage(String.valueOf(event.getEntity().getMetadata("me") != null));
//            Bukkit.broadcastMessage(String.valueOf(event.getEntity().getMetadata("we").isEmpty()));
//            event.setCancelled(true);
//            @SuppressWarnings("deprecation")
//            ItemStack itemStack = new ItemStack(entity.getMaterial(), 1, entity.getBlockData());
//            Item item = block.getWorld().dropItem(entity.getLocation(), itemStack);
//            item.setVelocity(new Vector());
//        }
//
//    }

    //@EventHandler
//    void blerp(PlayerMoveEvent event) {
//        if (herp) {
//            Material block = event.getPlayer().getLocation().getBlock().getType();
//            Bukkit.broadcastMessage(block.toString() + " " + block.isSolid() + block.isTransparent() + block.isOccluding());
//        }
//    }

//    @EventHandler(priority = EventPriority.MONITOR)
//    void entitydamagebyentity(EntityDamageByEntityEvent event)
//    {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(String.valueOf(i) + event.getCause().toString() + String.valueOf(event.isCancelled()));
//    }

//    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
//    void onDamageEvent(final EntityDamageEvent event) {
//        if (!herp)
//            return;
//        if (event.getEntityType() != EntityType.PLAYER)
//            return;
//        if (schedule)
//        {
//            final Player player = (Player)event.getEntity();
//            cancelVelocity.add(player);
//            Bukkit.broadcastMessage(String.valueOf(i));
//            new BukkitRunnable()
//            {
//                public void run()
//                {
//                    cancelVelocity.remove(player);
//                    i++;
//                    Bukkit.broadcastMessage(String.valueOf(i));
//                }
//            }.runTaskLater(this, 1L);
//            return;
//        }
//        final Vector vector = new Vector(0, 0, 0);
//        new BukkitRunnable() {
//            public void run() {
//                event.getEntity().setVelocity(vector);
//            }
//        }.runTaskLater(this, 1L);
//
//    }

//    @EventHandler
//    void velocityEvent(PlayerVelocityEvent event)
//    {
//        if (!herp)
//            return;
//        if (schedule)
//            event.setCancelled(true);
//        Bukkit.broadcastMessage(String.valueOf(i) + " velocity fired " + String.valueOf(event.isCancelled()));
//    }

//    @EventHandler
//    void resurrect(EntityResurrectEvent event)
//    {
//        if (!herp)
//            return;
//        event.setCancelled(false);
//    }

//    @EventHandler
//    void deathlootcheck(PlayerDeathEvent event)
//    {
//        if (herp)
//            event.setKeepInventory(true);
//    }

//    HashMap<Player, List<Location>> lastLocations = new HashMap<>();
//    @EventHandler(ignoreCancelled = true)
//    private void trackMoveHistory(PlayerMoveEvent event)
//    {
//        if (!herp)
//            return;
//        if (!lastLocations.containsKey(event.getPlayer()))
//            lastLocations.put(event.getPlayer(), new ArrayList<>());
//        List<Location> locations = lastLocations.get(event.getPlayer());
//        if (locations.size() > 60)
//            locations.remove(0);
//        locations.add(event.getTo());
//    }
//
//    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
//    private void onSwapHandsButton(PlayerSwapHandItemsEvent event)
//    {
//        if (!herp)
//            return;
//        World world = event.getPlayer().getWorld();
//        List<Location> locations = new ArrayList<>(lastLocations.get(event.getPlayer()));
//        Collections.reverse(locations);
//        new BukkitRunnable()
//        {
//            Iterator<Location> locationIterator = locations.iterator();
//            @Override
//            public void run()
//            {
//                if (!locationIterator.hasNext())
//                {
//                    cancel();
//                    return;
//                }
//                Location location = locationIterator.next();
//                if (location.getWorld() != world)
//                    return;
//                event.getPlayer().teleport(location);
//            }
//        }.runTaskTimer(this, 1L, 1L);
//        event.setCancelled(true);
//    }
//
//    @EventHandler
//    void onExplode(EntityExplodeEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getEntityType() != EntityType.PRIMED_TNT)
//            return;
//
//        TNTPrimed tnt = (TNTPrimed)event.getEntity();
//        System.out.println(tnt.hashCode());
//        Bukkit.broadcastMessage(tnt.getSource().toString());
//    }

//    @EventHandler
//    private void respawnEvent(PlayerRespawnEvent event)
//    {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(event.getEventName() + event.getPlayer().getName() + " Dead:" + event.getPlayer().isDead() + " location:" + event.getPlayer().getLocation().toString());
//    }
//
//    @EventHandler
//    private void teleports(PlayerTeleportEvent event)
//    {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(event.getEventName() + event.getPlayer().getName() + " Dead:" + event.getPlayer().isDead() + " cause:" + event.getCause().toString());
//
//    }
//
//    @EventHandler
//    private void changeWorld(PlayerChangedWorldEvent event)
//    {
//        if (!herp)
//            return;
//        Bukkit.broadcastMessage(event.getEventName() + event.getPlayer().getName() + " Dead:" + event.getPlayer().isDead());
//    }

//    @EventHandler
//    private void death(PlayerDeathEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getEntity().getKiller() != null)
//            event.getEntity().sendMessage(event.getEntity().getKiller().getName());
//    }

//    @EventHandler(priority = EventPriority.MONITOR)
//    void onHurt(EntityDamageEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getEntityType() != EntityType.PLAYER)
//            return;
//        //Enum#values()? What's that?
//        Bukkit.broadcastMessage("getDamage(): " + String.valueOf(event.getDamage()));
//        Bukkit.broadcastMessage("getFinalDamage(): " + String.valueOf(event.getFinalDamage()));
//        Bukkit.broadcastMessage("Base: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.BASE)));
//        Bukkit.broadcastMessage("Armor: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.ARMOR)));
//        Bukkit.broadcastMessage("Absorption: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.ABSORPTION)));
//        Bukkit.broadcastMessage("Blocking: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.BLOCKING)));
//        Bukkit.broadcastMessage("Hard hat: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.HARD_HAT)));
//        Bukkit.broadcastMessage("Magic: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.MAGIC)));
//        Bukkit.broadcastMessage("Resistance: " + String.valueOf(event.getOriginalDamage(EntityDamageEvent.DamageModifier.RESISTANCE)));
//    }
//
//    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
//    private void onPlayerDamage(EntityDamageEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getEntityType() != EntityType.PLAYER)
//            return;
//
//        if (!event.getEntity().isOp())
//            return;
//
//        CraftPlayer player = (CraftPlayer)event.getEntity();
//
//        EntityLiving nmsPlayer = player.getHandle();
//
//        final float originalShieldHealth = nmsPlayer.getAbsorptionHearts();
//
//        if (originalShieldHealth == 0)
//            return;
//        float shieldHealth = originalShieldHealth;
//        Bukkit.broadcastMessage("shieldHealth: " + String.valueOf(originalShieldHealth));
//        double armorDamage = event.getOriginalDamage(EntityDamageEvent.DamageModifier.ARMOR);
//
//        shieldHealth += armorDamage; //armordamage is negative
//
//        if (shieldHealth < 0)
//        {
//            event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, shieldHealth);
//            event.setDamage(EntityDamageEvent.DamageModifier.ABSORPTION, -originalShieldHealth);
//            return;
//        }
//
//        event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, -0.0);
//        event.setDamage(EntityDamageEvent.DamageModifier.ABSORPTION, event.getOriginalDamage(EntityDamageEvent.DamageModifier.ABSORPTION) + (shieldHealth - originalShieldHealth));
//    }

    int nodamage = 20;

//    @EventHandler
//    void onEntityDamage(EntityDamageEvent event)
//    {
//        if (!herp)
//            return;
//        if (!(event.getEntity() instanceof LivingEntity))
//            return;
//        ((LivingEntity)event.getEntity()).setNoDamageTicks(nodamage);
//    }

    @EventHandler
    private void chorusFlower(ProjectileHitEvent event)
    {
        if (!herp)
            return;
        if (event.getHitBlock() != null && event.getHitBlock().getType() == Material.CHORUS_FLOWER)
        {
            event.getHitBlock().setType(Material.AIR);
            Bukkit.broadcastMessage("chorus");

            Bukkit.getScheduler().runTask(this, () -> event.getHitBlock().setType(Material.CHORUS_FLOWER));
        }
    }

    @EventHandler
    private void chestNamer(PlayerInteractEvent event)
    {
        if (!herp)
            return;
        if (!event.getPlayer().isOp())
            return;
        if (event.getAction() != Action.LEFT_CLICK_BLOCK)
            return;

        Bukkit.broadcastMessage(event.getClickedBlock().getBlockData().getAsString());

        if (true) return;
        Chest chest = (Chest)event.getClickedBlock().getState();
        String name = chest.getCustomName();
        getConfig().set("yolos", name);
        String[] args = name.split(" ");
        getConfig().set("yolo", String.join(" ", args).replaceAll("&", "\u00A7"));
        String newArgs[] = String.join(" ", args).replaceAll("&", "\u00A7").split(" ");
        for (int i = 0; i < newArgs.length; i++)
            getConfig().set(String.valueOf(i), newArgs[i]);
        saveConfig();
        Bukkit.broadcastMessage(name);
    }

    private double maxDistance = 0;
    private double maxYDistance = 0;

    //@EventHandler
    private void onPlayerMove(PlayerMoveEvent event)
    {
        if (!herp)
            return;
        Player player = event.getPlayer();

        if (!player.isOp())
            return;

        player.sendActionBar(maxDistance + " y:" + maxYDistance);

        Location from = event.getFrom().clone();
        from.setY(event.getTo().getY());

        double distance = from.distanceSquared(event.getTo());
        if (distance > maxDistance)
            maxDistance = distance;
        double yDistance = event.getTo().getY() - event.getFrom().getY();
        if (yDistance > maxYDistance)
            maxYDistance = yDistance;

        player.sendMessage(distance + " y:" + yDistance);
        Location anotherFrom = event.getFrom().clone();
        anotherFrom.add(0,-1,0);
        player.sendMessage(anotherFrom.getBlock().getType().name());
    }

//    @EventHandler
//    private void testCraft(InventoryCloseEvent event)
//    {
//        if (!herp)
//            return;
//        if (!event.getPlayer().isOp())
//            return;
//        CraftingInventory inventory = (CraftingInventory) event.getInventory();
//        Map<Material, Character> ingredients = new HashMap<>();
//        ingredients.put(null, 'a');
//        char i = 'b';
//        for (ItemStack item : inventory.getMatrix())
//        {
//            if (item == null || ingredients.containsKey(item.getType()))
//                continue;
//            ingredients.put(item.getType(), i++);
//        }
//        getShapedMatrix(ingredients, inventory.getMatrix());
//    }

//    @EventHandler(priority = EventPriority.LOWEST)
//    private void onBlockBreak(BlockBreakEvent event)
//    {
//        if (!herp)
//            return;
//        if (event.getBlock().getType().equals(Material.WALL_SIGN))
//            for (String line : ((Sign)event.getBlock().getState()).getLines())
//                event.getPlayer().sendMessage(line.replaceAll(" ", "|"));
//        event.setCancelled(true);
//    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onSave(WorldSaveEvent event)
    {
        if (!herp)
            return;
        getLogger().info("save called for " + event.getWorld());
        for (StackTraceElement element : Thread.currentThread().getStackTrace())
            getLogger().info(element.toString());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onEggThrow(PlayerEggThrowEvent event)
    {
        if (!herp)
            return;
        Bukkit.broadcastMessage("eggHatch location: " + event.getEgg().getLocation());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onBlockBreak(BlockPlaceEvent event)
    {
        if (!herp)
            return;
        Bukkit.broadcastMessage(((Chest)event.getBlock().getState()).getInventory().getHolder().getClass().getSimpleName());
        Bukkit.broadcastMessage(Boolean.toString(((Chest)event.getBlock().getState()).getInventory().getHolder() instanceof DoubleChest));
//        for (BlockFace face : BlockFace.values())
//            Bukkit.broadcastMessage(face.toString() + Boolean.toString(event.getBlock().getState() == event.getBlock().getRelative(face).getState()));
        new BukkitRunnable()
        {
            Location location = event.getBlock().getLocation();
            @Override
            public void run()
            {
                DoubleChest doubleChest = (DoubleChest)((Chest)event.getBlock().getState()).getInventory().getHolder();

                Bukkit.broadcastMessage((doubleChest.getLeftSide().getInventory().getLocation().toString()));
                Bukkit.broadcastMessage(((Chest)doubleChest.getLeftSide()).getInventory().getLocation().toString());
                Bukkit.broadcastMessage(((Chest)doubleChest.getLeftSide()).getLocation().toString());
                Bukkit.broadcastMessage(((Chest)doubleChest.getLeftSide()).getBlock().getLocation().toString());
                Bukkit.broadcastMessage(((Chest)doubleChest.getLeftSide()).getBlockInventory().getLocation().toString());



                Bukkit.broadcastMessage(((Chest)event.getBlock().getState()).getInventory().getHolder().getClass().getSimpleName());
                Bukkit.broadcastMessage(Boolean.toString(((Chest)event.getBlock().getState()).getInventory().getHolder() instanceof DoubleChest));
                //BlockState state = event.getBlock().getRelative(BlockFace.SELF).getState();
                BlockState state = event.getBlock().getWorld().getBlockAt(event.getBlock().getLocation()).getState();
                Bukkit.broadcastMessage(((Chest)state).getInventory().getHolder().getClass().getSimpleName());
                Bukkit.broadcastMessage(Boolean.toString(((Chest)state).getInventory().getHolder() instanceof DoubleChest));
                state = event.getBlock().getRelative(BlockFace.SELF).getState();
                Bukkit.broadcastMessage(((Chest)state).getInventory().getHolder().getClass().getSimpleName());
                Bukkit.broadcastMessage(Boolean.toString(((Chest)state).getInventory().getHolder() instanceof DoubleChest));
//                for (BlockFace face : BlockFace.values())
//                    Bukkit.broadcastMessage(face.toString() + Boolean.toString(state == event.getBlock().getRelative(face).getState()));
            }
        }.runTaskLater(this, 2L);
    }


    private Location firstLocation;

    private BukkitTask task;
    private volatile BukkitTask waxTask;
    private static final int WAX_BATCH_PER_TICK = 16;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("hotfix"))
        {
            if (task != null)
                task.cancel();
            task = null;
            if (args.length < 1)
            {
                herp = !herp;
                sender.sendMessage(String.valueOf(herp));
                maxDistance = 0;
            }
            else if (args.length >= 1) //redundant
            {
                Player player = null;
                if (sender instanceof Player)
                    player = (Player)sender;

                if (args[0].equalsIgnoreCase("uuid"))
                {
                    OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(UUID.fromString(args[1]));
                    sender.sendMessage(offlinePlayer.toString());
                    sender.sendMessage(offlinePlayer.getUniqueId().toString());
                    sender.sendMessage(offlinePlayer.getName());
                }
                else if (args[0].equalsIgnoreCase("bed"))
                {
                    player.sendMessage(player.getBedSpawnLocation().toString());
                }
                else if (args[0].equalsIgnoreCase("name"))
                {
                    OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[1]);
                    sender.sendMessage(offlinePlayer.toString());
                    sender.sendMessage(offlinePlayer.getUniqueId().toString());
                    sender.sendMessage(offlinePlayer.getName());
                }
                else if (args[0].equalsIgnoreCase("attack"))
                {
                    Bukkit.getPlayerExact(args[1]).damage(0.5D, (Player)sender);
                }
                else if (args[0].equalsIgnoreCase("schedule"))
                {
                    if (schedule)
                        schedule = false;
                    else
                        schedule = true;
                    sender.sendMessage("Schedule: " + String.valueOf(schedule));
                }
                else if (args[0].equalsIgnoreCase("rename"))
                {
                    ItemStack itemStack = player.getInventory().getItemInMainHand();
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    String name = args[1];
                    for (int i = 2; i < args.length; i++)
                        name = name + " " + args[i];
                    name = ChatColor.translateAlternateColorCodes('&', name);
                    itemMeta.setDisplayName(name);
                    itemStack.setItemMeta(itemMeta);
                }
                else if (args[0].equalsIgnoreCase("dura")) //durability
                {
                    ItemStack itemStack = player.getInventory().getItemInMainHand();
                    if (itemStack == null) return false;
                    sender.sendMessage(String.valueOf(itemStack.getDurability()));
                    sender.sendMessage(String.valueOf(itemStack.getType().getMaxDurability()));
                }
                else if (args[0].equalsIgnoreCase("health"))
                {
                    player.sendMessage(String.valueOf(player.getMaxHealth()));
                    player.sendMessage(String.valueOf(player.getHealth()));
                    player.sendMessage(String.valueOf(player.getHealthScale()));
                }
                else if (args[0].equalsIgnoreCase("fixhealth"))
                {
                    Player player1 = Bukkit.getPlayer(args[1]);
                    player1.setHealthScaled(false);
                }
                else if (args[0].equalsIgnoreCase("nodamageticks"))
                {
                    Player player1 = Bukkit.getPlayer(args[1]);
                    player1.setMaximumNoDamageTicks(Integer.parseInt(args[2]));
                }
                else if (args[0].equalsIgnoreCase("setnodamage"))
                {
                    nodamage = Integer.parseInt(args[1]);
                }
                else if (args[0].equalsIgnoreCase("lag"))
                {
                    try
                    {
                        Thread.sleep(Long.parseLong(args[1]));
                    }
                    catch (Exception ignored) {}

                }
                else if (args[0].equalsIgnoreCase("destroyscheduler"))
                {
                    getServer().broadcastMessage("El ");
                    new BukkitRunnable()
                    {
                        public void run()
                        {
                            getServer().broadcastMessage("oh el");
                        }
                    }.runTaskTimer(this, 1L, ((long)Float.MAX_VALUE / 2));
                }
                else if (args[0].equalsIgnoreCase("permission"))
                {
                    Player player1 = Bukkit.getPlayer(args[1]);
                    player.sendMessage(player1.getName() + String.valueOf(player1.hasPermission(args[2])));
                }
//                else if (args[0].equalsIgnoreCase("shieldhealth"))
//                {
//                    toggleShieldDebug(player);
//                }
                else if (args[0].equalsIgnoreCase("damage"))
                {
                    player.damage(Double.valueOf(args[1]));
                }
                else if (args[0].equalsIgnoreCase("speed"))
                {
                    player.setWalkSpeed(Float.valueOf(args[1]));
                }
                else if (args[0].equalsIgnoreCase("perm"))
                {
                    Player player1 = Bukkit.getPlayer(args[1]);
                    sender.sendMessage(String.valueOf(player1.hasPermission(args[2])));
                }
                else if (args[0].equalsIgnoreCase("book"))
                {
                    TextComponent textComponent = new TextComponent(args[1]);
                    textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, args[2]));
                    if (args.length > 3)
                        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(args[3])));
                    player.sendMessage(getClickableChat(args[1], args[2], args[3]));
                    List<BaseComponent> baseComponents = new ArrayList<>();
                    baseComponents.add(getClickableChat(args[1], args[2], args[3]));
                    baseComponents.add(getClickableChat(args[1], args[2], args[3]));
                    baseComponents.addAll(Arrays.asList(TextComponent.fromLegacyText("testing")));
                    player.sendMessage(baseComponents.toArray(new BaseComponent[0]));
                    player.sendMessage(buildPage(getClickableChat(args[1], args[2], args[3]), getClickableChat(args[1], args[2], args[3])));
                }
                else if (args[0].equalsIgnoreCase("action"))
                {
                    player.sendActionBar('&', String.join(" ", args));
                }
                else if (args[0].equalsIgnoreCase("music"))
                {
                    for (int i = 0; i < 10; i++)
                        player.playSound(new Location(player.getWorld(), 2, 5, 298), args[1], SoundCategory.RECORDS, Float.valueOf(args[2]), 1.0f);
                }
                else if (args[0].equalsIgnoreCase("distance"))
                {

                    if (firstLocation == null)
                    {
                        Player finalPlayer = player;
                        firstLocation = player.getTargetBlock(null, 100).getLocation();
                        new BukkitRunnable()
                        {
                            @Override
                            public void run()
                            {
                                if (firstLocation == null)
                                {
                                    cancel();
                                    return;
                                }
                                finalPlayer.sendActionBar(Double.toString(firstLocation.distance(finalPlayer.getLocation())));
                            }
                        }.runTaskTimer(this, 40L, 40L);
                    }
                    else
                    {
                        firstLocation = null;
                    }
                }
                else if (args[0].equalsIgnoreCase("sentry"))
                {
                    if (firstLocation != null)
                    {
                        firstLocation = null;
                        return true;
                    }
                    firstLocation = player.getTargetBlock(null, 10).getLocation();
                    Player finalPlayer = player;
                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            if (firstLocation == null)
                            {
                                cancel();
                                return;
                            }


                            Vector vector = getClosestPlayer(firstLocation).getLocation().add(0, 1.5, 0).toVector().subtract(firstLocation.toVector());
                            Iterator<Block> blocks = new BlockIterator(firstLocation.getWorld(), firstLocation.toVector(), vector, 0, Math.min(100, (int)vector.length()));
                            blocks.next();
                            blocks.next();
                            while (blocks.hasNext())
                            {
                                Block block = blocks.next();
                                if (block.getType() != Material.AIR)
                                    finalPlayer.sendActionBar(block.toString());
                            }
                            firstLocation.getWorld().spawnArrow(firstLocation, vector, 2, 0).setGravity(false);
                        }
                    }.runTaskTimer(this, 20L, 20L);
                }
                else if (args[0].equalsIgnoreCase("glow"))
                {
                    player.sendMessage(String.valueOf(player.isGlowing()));
                    player.setGlowing(!player.isGlowing());
                }
                else if (args[0].equalsIgnoreCase("damagemob"))
                {
                    for (Entity entity : player.getNearbyEntities(5,5,5))
                    {
                        if (entity.getType() != EntityType.PLAYER && entity instanceof Damageable)
                            ((Damageable)entity).damage(Double.parseDouble(args[1]));
                    }
                }
                else if (args[0].equalsIgnoreCase("bounce"))
                {
                    Location location = player.getLocation().add(player.getLocation().getDirection());
                    Item grenade = location.getWorld().dropItem(location, new ItemStack(Material.TNT));
                    grenade.setCanMobPickup(false);
                    grenade.setPickupDelay(Integer.MAX_VALUE);
                    grenade.setVelocity(location.getDirection());
                    Player finalPlayer = player;

                    new BukkitRunnable()
                    {
                        int duration = 60;

                        @Override
                        public void run()
                        {
                            if (--duration <= 0)
                            {
                                grenade.remove();
                                grenade.getWorld().createExplosion(grenade.getLocation(), 1f, false, false);
                                cancel();
                            }
                            Vector vector = grenade.getVelocity();
                            int length = Math.max(2, (int)Math.round(vector.length()));
                            BlockIterator blockIterator = new BlockIterator(grenade.getWorld(), vector, vector, 0, length);
                            Block previousBlock = null;
                            Block collidingBlock = null;
                            while ((collidingBlock == null || collidingBlock.getType() != Material.AIR) && blockIterator.hasNext())
                            {
                                previousBlock = collidingBlock;
                                collidingBlock = blockIterator.next();
                            }

                            if (collidingBlock == null || collidingBlock.getType() == Material.AIR)
                                return;

                            switch (collidingBlock.getFace(previousBlock))
                            {
                                case UP:
                                case DOWN:
                                    vector.setY(-vector.getY());
                                    break;
                                case EAST:
                                case WEST:
                                    vector.setX(-vector.getX());
                                case NORTH:
                                case SOUTH:
                                    vector.setZ(-vector.getZ());
                            }
                            finalPlayer.sendActionBar(collidingBlock.getFace(previousBlock).toString());
                            grenade.setVelocity(vector);
                        }
                    }.runTaskTimer(this, 1L, 1L);
                }
                else if (args[0].equalsIgnoreCase("warpspeed"))
                {
                    task = new BukkitRunnable()
                    {
                        int speed = 1;

                        @Override
                        public void run()
                        {
                            //player.setVelocity(player.getLocation().getDirection().multiply(16));
                            //player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, speed++, true, false));
                            //player.getWorld().spawnParticle(Particle.SPIT, player.getLocation().add(player.getLocation().getDirection().multiply(16)), 20);
                        }
                    }.runTaskTimer(this, 1L, 1L);
                }
                else if (args[0].equalsIgnoreCase("version"))
                {
                    getServer().broadcastMessage(getServer().getVersion());
                    getServer().broadcastMessage(getServer().getBukkitVersion());
                    getServer().broadcastMessage(getServer().getName());
                }
                else if (args[0].equalsIgnoreCase("chat"))
                {
                    player.chat("" + args[1]);
                    return true;
                }
                else if (args[0].equalsIgnoreCase("color"))
                {
                    Bukkit.broadcastMessage(String.join(" ", args) + ";");
                    Bukkit.broadcastMessage(String.join(" ", args) + ";");
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', String.join(" ", args) + ";"));
                    System.out.println(ChatColor.translateAlternateColorCodes('&', String.join(" ", args) + ";"));
                    System.out.println(String.join(" ", args).replaceAll("&", "\u00A7") + ";");
                    System.out.println(String.join(" ", args).replaceAll("&", "\u00A7") + ";");
                    Bukkit.broadcastMessage(String.valueOf(String.join(" ", args).replaceAll("&", "\u00A7").length()));
                    Bukkit.broadcastMessage(String.valueOf(args.length));
                    Bukkit.broadcastMessage(String.valueOf(String.join(" ", args).replaceAll("&", "\u00A7").split(" ").length));
                    getConfig().set("yolo", String.join(" ", args).replaceAll("&", "\u00A7"));
                    String newArgs[] = String.join(" ", args).replaceAll("&", "\u00A7").split(" ");
                    for (int i = 0; i < newArgs.length; i++)
                        getConfig().set(String.valueOf(i), newArgs[i]);
                    saveConfig();
                }
                else if (args[0].equalsIgnoreCase("gencheck"))
                {
                    player.sendMessage("checking generator for " + args[1]);
                    player.sendMessage(String.valueOf(getServer().getWorld(args[1])));
                    player.sendMessage(String.valueOf(getServer().getWorld(args[1]).getGenerator()));
                    player.sendMessage(String.valueOf(getServer().getWorld(args[1]).getGenerator().getClass()));
                    player.sendMessage(getServer().getWorld(args[1]).getGenerator().getClass().getName());
                }
                else if (args[0].equalsIgnoreCase("skullcheck"))
                {
                    sender.sendMessage(((SkullMeta)player.getInventory().getItemInMainHand().getItemMeta()).getOwningPlayer().getName());
                }
                else if (args[0].equalsIgnoreCase("explode"))
                {
                    sender.sendMessage("power, fire, break");
                    player.getLocation().getWorld().createExplosion(player.getLocation(), Float.parseFloat(args[1]), args[2].equalsIgnoreCase("fire"), args[3].equalsIgnoreCase("break"));
                }
                else if (args[0].equalsIgnoreCase("withercheck"))
                {
                    for (Entity entity : player.getWorld().getEntities())
                    {
                        if (entity instanceof Wither)
                            sender.sendMessage("getRemoveWhenFarAway(): " + ((Wither) entity).getRemoveWhenFarAway());
                    }
                }
                else if (args[0].equalsIgnoreCase("waxsigns") || args[0].equalsIgnoreCase("wax"))
                {
                    if (!sender.hasPermission("hotfix.waxsigns"))
                    {
                        sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                        return true;
                    }
                    String worldArg = args.length >= 2 ? args[1] : null;
                    if (!waxSigns(sender, worldArg))
                        return false;
                }
            }

            return true;
        }

        if (cmd.getName().equalsIgnoreCase("waxsigns"))
        {
            String worldArg = args.length >= 1 ? args[0] : null;
            if (!waxSigns(sender, worldArg))
                return false;
            return true;
        }


//        if (cmd.getName().equalsIgnoreCase("goldleggings"))
//        {
//            Player player = (Player)sender;
//            if (player.getWorld().getName().equalsIgnoreCase("CreativeParkourMaps"))
//                return false;
//            if (args.length < 2)
//                return false;
//            int levitation;
//            int jump;
//            try
//            {
//                levitation = Integer.parseInt(args[0]);
//                jump = Integer.parseInt(args[1]);
//            }
//            catch (Throwable rock)
//            {
//                return false;
//            }
//            for (PotionEffect potionEffect : player.getActivePotionEffects())
//                player.removePotionEffect(potionEffect.getType());
//            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 1200, levitation, true, false));
//            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, jump, true, false));
//        }
        return false;
    }

    private boolean waxSigns(CommandSender sender, String worldName)
    {
        World world;
        if (worldName != null && !worldName.isEmpty())
        {
            world = Bukkit.getWorld(worldName);
            if (world == null)
            {
                sender.sendMessage(ChatColor.RED + "World not found: " + worldName);
                return true;
            }
        }
        else
        {
            if (!(sender instanceof Player))
            {
                sender.sendMessage(ChatColor.RED + "Usage: /waxsigns <world>");
                return false;
            }
            world = ((Player) sender).getWorld();
        }

        if (waxTask != null)
        {
            sender.sendMessage(ChatColor.RED + "A wax task is already running. Wait for it to finish.");
            return true;
        }

        final World targetWorld = world;
        final String senderName = sender.getName();
        sender.sendMessage(ChatColor.YELLOW + "Scanning region files in " + targetWorld.getName() + " (no new chunks will be generated)...");

        // Heavy file IO off the main thread
        Bukkit.getScheduler().runTaskAsynchronously(this, new Runnable()
        {
            @Override
            public void run()
            {
                final List<Long> chunkKeys = collectExistingChunkKeys(targetWorld);
                final Set<Long> beforeChunks = new HashSet<Long>(chunkKeys);
                final Set<String> beforeRegions = listRegionFileNames(targetWorld);
                Bukkit.getScheduler().runTask(Main.this, new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (chunkKeys.isEmpty())
                        {
                            CommandSender liveSender = Bukkit.getConsoleSender().getName().equals(senderName)
                                    ? Bukkit.getConsoleSender() : Bukkit.getPlayerExact(senderName);
                            if (liveSender == null)
                                liveSender = sender;
                            liveSender.sendMessage(ChatColor.YELLOW + "No existing chunks found in world " + targetWorld.getName() + ". Nothing to wax.");
                            return;
                        }
                        startAsyncWax(targetWorld, chunkKeys, senderName, sender, beforeChunks, beforeRegions);
                    }
                });
            }
        });
        return true;
    }

    private List<java.io.File> getRegionDirs(World world)
    {
        List<java.io.File> regionDirs = new ArrayList<java.io.File>();
        regionDirs.add(new java.io.File(world.getWorldFolder(), "region"));
        // Vanilla single-folder layout fallback (Bukkit normally uses one folder per world)
        regionDirs.add(new java.io.File(world.getWorldFolder(), "DIM-1/region"));
        regionDirs.add(new java.io.File(world.getWorldFolder(), "DIM1/region"));
        return regionDirs;
    }

    private Set<String> listRegionFileNames(World world)
    {
        Set<String> names = new HashSet<String>();
        for (java.io.File regionDir : getRegionDirs(world))
        {
            if (!regionDir.isDirectory())
                continue;
            java.io.File[] regionFiles = regionDir.listFiles(new java.io.FileFilter()
            {
                @Override
                public boolean accept(java.io.File file)
                {
                    String name = file.getName();
                    return name.startsWith("r.") && name.endsWith(".mca");
                }
            });
            if (regionFiles == null)
                continue;
            for (java.io.File regionFile : regionFiles)
                names.add(regionDir.getName() + "/" + regionFile.getName());
        }
        return names;
    }

    /**
     * Enumerates chunks that already exist on disk by parsing region file headers.
     * Never touches non-existent chunks, so nothing can be generated by this step.
     * Packed key: (x << 32) | (z & 0xffffffffL).
     */
    private List<Long> collectExistingChunkKeys(World world)
    {
        List<Long> keys = new ArrayList<Long>();
        List<java.io.File> regionDirs = getRegionDirs(world);

        for (java.io.File regionDir : regionDirs)
        {
            if (!regionDir.isDirectory())
                continue;
            java.io.File[] regionFiles = regionDir.listFiles(new java.io.FileFilter()
            {
                @Override
                public boolean accept(java.io.File file)
                {
                    String name = file.getName();
                    return name.startsWith("r.") && name.endsWith(".mca");
                }
            });
            if (regionFiles == null)
                continue;
            for (java.io.File regionFile : regionFiles)
            {
                String[] parts = regionFile.getName().split("\\.");
                if (parts.length != 4)
                    continue;
                final int regionX;
                final int regionZ;
                try
                {
                    regionX = Integer.parseInt(parts[1]);
                    regionZ = Integer.parseInt(parts[2]);
                }
                catch (NumberFormatException ignored)
                {
                    continue;
                }
                // MCA header: 1024 x 4-byte big-endian location entries. Non-zero offset = chunk exists.
                java.io.RandomAccessFile raf = null;
                try
                {
                    raf = new java.io.RandomAccessFile(regionFile, "r");
                    if (raf.length() < 4096)
                        continue;
                    byte[] header = new byte[4096];
                    raf.readFully(header);
                    for (int i = 0; i < 1024; i++)
                    {
                        int entry = ((header[i * 4] & 0xFF) << 24)
                                | ((header[i * 4 + 1] & 0xFF) << 16)
                                | ((header[i * 4 + 2] & 0xFF) << 8)
                                | (header[i * 4 + 3] & 0xFF);
                        if ((entry >>> 8) == 0)
                            continue; // chunk not present in file, skip without loading
                        int chunkX = regionX * 32 + (i % 32);
                        int chunkZ = regionZ * 32 + (i / 32);
                        keys.add((((long) chunkX) << 32) | (((long) chunkZ) & 0xffffffffL));
                    }
                }
                catch (Exception e)
                {
                    getLogger().warning("Skipping unreadable region file " + regionFile.getName() + ": " + e.getMessage());
                }
                finally
                {
                    if (raf != null)
                    {
                        try { raf.close(); } catch (Exception ignored) {}
                    }
                }
            }
        }
        return keys;
    }

    private void startAsyncWax(final World world, final List<Long> chunkKeys, final String senderName, final CommandSender fallbackSender,
                               final Set<Long> beforeChunks, final Set<String> beforeRegions)
    {
        final Set<Long> initiallyLoaded = new HashSet<Long>();
        for (Chunk chunk : world.getLoadedChunks())
            initiallyLoaded.add((((long) chunk.getX()) << 32) | (((long) chunk.getZ()) & 0xffffffffL));

        final AtomicInteger index = new AtomicInteger(0);
        final AtomicInteger pending = new AtomicInteger(0);
        final AtomicInteger checked = new AtomicInteger(0);
        final AtomicInteger waxed = new AtomicInteger(0);
        final int total = chunkKeys.size();

        sendToSender(senderName, fallbackSender, ChatColor.YELLOW + "Waxing signs in " + total + " existing chunks in " + world.getName() + "...");

        waxTask = new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // World went away mid-run
                if (Bukkit.getWorld(world.getName()) != world)
                {
                    cancel();
                    waxTask = null;
                    sendToSender(senderName, fallbackSender, ChatColor.RED + "Wax cancelled: world unloaded.");
                    return;
                }

                // Dispatch a small batch per tick so we never load everything at once
                for (int i = 0; i < WAX_BATCH_PER_TICK; i++)
                {
                    int slot = index.getAndIncrement();
                    if (slot >= total)
                    {
                        index.decrementAndGet(); // don't overshoot; queue is drained
                        break;
                    }
                    final long key = chunkKeys.get(slot);
                    final int x = (int) (key >> 32);
                    final int z = (int) key;
                    pending.incrementAndGet();
                    try
                    {
                        // gen=false is critical: Paper will never generate a new chunk here.
                        // Non-existent chunks were already filtered via region headers, so a null
                        // result just means nothing to do.
                        world.getChunkAtAsync(x, z, false, true).thenAccept(new java.util.function.Consumer<Chunk>()
                        {
                            @Override
                            public void accept(final Chunk chunk)
                            {
                                // Tile-entity mutation + unload must happen on the main thread
                                Bukkit.getScheduler().runTask(Main.this, new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        try
                                        {
                                            if (chunk != null)
                                                waxed.addAndGet(waxChunk(chunk));
                                        }
                                        finally
                                        {
                                            checked.incrementAndGet();
                                            // Unload chunks we pulled in; leave already-loaded ones alone
                                            if (chunk != null && !initiallyLoaded.contains(key))
                                            {
                                                try { world.unloadChunk(x, z, true); } catch (Exception ignored) {}
                                            }
                                            if (pending.decrementAndGet() == 0 && index.get() >= total)
                                                finishWax(world, senderName, fallbackSender, checked.get(), waxed.get(), total, beforeChunks, beforeRegions);
                                        }
                                    }
                                });
                            }
                        }).exceptionally(new java.util.function.Function<Throwable, Void>()
                        {
                            @Override
                            public Void apply(Throwable throwable)
                            {
                                Bukkit.getScheduler().runTask(Main.this, new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        checked.incrementAndGet();
                                        if (pending.decrementAndGet() == 0 && index.get() >= total)
                                            finishWax(world, senderName, fallbackSender, checked.get(), waxed.get(), total, beforeChunks, beforeRegions);
                                    }
                                });
                                return null;
                            }
                        });
                    }
                    catch (Throwable t)
                    {
                        // e.g. API missing on non-Paper: count as checked so the run can still finish
                        checked.incrementAndGet();
                        pending.decrementAndGet();
                        getLogger().warning("Async chunk load failed at " + x + "," + z + ": " + t.getMessage());
                    }
                }

                // Queue drained and nothing in flight (covers total == 0 edge and sync failures)
                if (index.get() >= total && pending.get() == 0)
                    finishWax(world, senderName, fallbackSender, checked.get(), waxed.get(), total, beforeChunks, beforeRegions);
            }
        }.runTaskTimer(this, 1L, 5L);
    }

    private void finishWax(final World world, final String senderName, final CommandSender fallbackSender,
                           final int checked, final int waxed, final int total,
                           final Set<Long> beforeChunks, final Set<String> beforeRegions)
    {
        if (waxTask != null)
        {
            try { waxTask.cancel(); } catch (Exception ignored) {}
            waxTask = null;
        }
        else
        {
            return; // already finished
        }
        final String worldName = world.getName();
        final int beforeCount = beforeChunks != null ? beforeChunks.size() : total;
        sendToSender(senderName, fallbackSender, ChatColor.GREEN + "Waxed " + waxed + " sign(s) across "
                + checked + "/" + total + " existing chunks in world " + worldName + ". Verifying no new chunks were generated...");

        // Re-scan region headers off-thread, then diff against the pre-run snapshot.
        // Waxing dirties chunks (expected file mtime/size changes), but the SET of
        // existing chunks must not grow. Any growth means generation happened.
        Bukkit.getScheduler().runTaskAsynchronously(this, new Runnable()
        {
            @Override
            public void run()
            {
                List<Long> afterList;
                Set<String> afterRegions;
                try
                {
                    afterList = collectExistingChunkKeys(world);
                    afterRegions = listRegionFileNames(world);
                }
                catch (Exception e)
                {
                    final String err = e.getMessage();
                    Bukkit.getScheduler().runTask(Main.this, new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            sendToSender(senderName, fallbackSender, ChatColor.YELLOW + "Wax done, but verification scan failed: " + err);
                            getLogger().warning("[waxsigns] verification scan failed in " + worldName + ": " + err);
                        }
                    });
                    return;
                }

                Set<Long> afterSet = new HashSet<Long>(afterList);
                List<Long> newChunks = new ArrayList<Long>();
                if (beforeChunks != null)
                {
                    for (Long key : afterSet)
                    {
                        if (!beforeChunks.contains(key))
                            newChunks.add(key);
                    }
                }
                Set<String> newRegions = new HashSet<String>(afterRegions);
                if (beforeRegions != null)
                    newRegions.removeAll(beforeRegions);

                final int afterCount = afterSet.size();
                final int newChunkCount = newChunks.size();
                final int newRegionCount = newRegions.size();

                // Build a short sample for chat; full list goes to console
                StringBuilder sample = new StringBuilder();
                int sampleSize = Math.min(newChunks.size(), 5);
                for (int i = 0; i < sampleSize; i++)
                {
                    long key = newChunks.get(i);
                    if (i > 0)
                        sample.append(", ");
                    sample.append("(").append((int) (key >> 32)).append(",").append((int) (long) key).append(")");
                }
                final String sampleStr = sample.toString();

                if (newChunkCount > 0 || newRegionCount > 0)
                {
                    StringBuilder full = new StringBuilder();
                    int logged = Math.min(newChunks.size(), 50);
                    for (int i = 0; i < logged; i++)
                    {
                        long key = newChunks.get(i);
                        if (i > 0)
                            full.append(", ");
                        full.append("(").append((int) (key >> 32)).append(",").append((int) (long) key).append(")");
                    }
                    getLogger().warning("[waxsigns] GENERATION CHECK FAILED in " + worldName + ": before=" + beforeCount
                            + " after=" + afterCount + " newChunks=" + newChunkCount + " newRegions=" + newRegionCount
                            + " " + newRegions + (full.length() > 0 ? " sample=" + full : ""));
                }
                else
                {
                    getLogger().info("[waxsigns] Generation check passed in " + worldName + ": before=" + beforeCount + " after=" + afterCount);
                }

                Bukkit.getScheduler().runTask(Main.this, new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (newChunkCount == 0 && newRegionCount == 0)
                        {
                            sendToSender(senderName, fallbackSender, ChatColor.GREEN + "Verified: no new chunks generated "
                                    + "(before=" + beforeCount + ", after=" + afterCount + ", +" + newRegionCount + " region files).");
                        }
                        else
                        {
                            sendToSender(senderName, fallbackSender, ChatColor.RED + "WARNING: " + newChunkCount
                                    + " new chunk(s), " + newRegionCount + " new region file(s) appeared during the run "
                                    + "(before=" + beforeCount + ", after=" + afterCount + "). "
                                    + "The wax task itself uses gen=false and cannot generate chunks, so these likely came from players/exploration/other plugins"
                                    + (sampleStr.isEmpty() ? "." : ". Sample: " + sampleStr + ".")
                                    + " See console for details.");
                        }
                    }
                });
            }
        });
    }

    private void sendToSender(String senderName, CommandSender fallback, String message)
    {
        CommandSender target = null;
        if (senderName != null)
        {
            target = Bukkit.getPlayerExact(senderName);
            if (target == null && Bukkit.getConsoleSender().getName().equals(senderName))
                target = Bukkit.getConsoleSender();
        }
        if (target == null)
            target = fallback;
        if (target != null)
        {
            try { target.sendMessage(message); } catch (Exception ignored) {}
        }
    }

    private int waxChunk(Chunk chunk)
    {
        int count = 0;
        for (BlockState state : chunk.getTileEntities())
        {
            if (!(state instanceof Sign))
                continue;
            Sign sign = (Sign) state;
            if (sign.isWaxed())
                continue;
            sign.setWaxed(true);
            sign.update(true);
            count++;
        }
        return count;
    }

    private Player getClosestPlayer(Location location)
    {
        Player player = null;
        double distance = Double.MAX_VALUE;
        for (Player onlinePlayer : location.getWorld().getPlayers())
        {
            double checkDistance = onlinePlayer.getLocation().distanceSquared(location);
            if (checkDistance < distance)
            {
                player = onlinePlayer;
                distance = checkDistance;
            }
        }
        return player;
    }

    private TextComponent getClickableChat(String message, String command, String hover)
    {
        TextComponent textComponent = new TextComponent(message);
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        if (hover != null)
            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(hover)));
        return textComponent;
    }

    private BaseComponent[] buildPage(Object... strings)
    {
        List<BaseComponent> baseComponents = new ArrayList<>(strings.length);
        for (Object object : strings)
        {
            if (object instanceof TextComponent)
                baseComponents.add((TextComponent)object);
            else if (object instanceof String)
                baseComponents.addAll(Arrays.asList(TextComponent.fromLegacyText((String)object)));
        }
        return baseComponents.toArray(new BaseComponent[0]);
    }

    @EventHandler
    private void onWorldChange(PlayerChangedWorldEvent event)
    {
        if (event.getPlayer().getWorld().getName().equalsIgnoreCase("CreativeParkourMaps"))
            for (PotionEffect potionEffect : event.getPlayer().getActivePotionEffects())
                event.getPlayer().removePotionEffect(potionEffect.getType());
    }

    Player debugger = null;
//    ShieldUtils shieldUtils;
//
//    private void toggleShieldDebug(Player player)
//    {
//        if (debugger == null)
//            debugger = player;
//        else
//            debugger = null;
//        if (shieldUtils == null)
//            shieldUtils = ((AbsorptionShields)getServer().getPluginManager().getPlugin("AbsorptionShields")).getShieldUtils();
//    }

//    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
//    private void onDamage(EntityDamageEvent event)
//    {
//        if (debugger == null)
//            return;
//        if (event.getEntity() != debugger)
//            return;
//        debugger.sendMessage(event.getDamage() + "; " + event.getFinalDamage() + "; " + shieldUtils.getShieldHealth(debugger));
//    }
//
//    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
//    private void onHeal(EntityRegainHealthEvent event)
//    {
//        if (debugger == null)
//            return;
//        if (event.getEntity() != debugger)
//            return;
//        if (event.getRegainReason() != EntityRegainHealthEvent.RegainReason.CUSTOM)
//            return;
//        debugger.sendMessage("Shield " + shieldUtils.getShieldHealth(debugger));
//    }

    // ProjectKorra hotfix: This code cancels Explosions from other plugins
    // https://github.com/ProjectKorra/ProjectKorra/issues/400
//    @EventHandler (priority = EventPriority.LOWEST)
//    public void onEntityDamageByBlock(EntityDamageByBlockEvent event)
//    {
//        if (!event.isCancelled())
//            return;
//
//        if (event.getCause().equals(DamageCause.BLOCK_EXPLOSION))
//        {
//            if (event.getDamager() == null)
//            {
//            	event.setCancelled(false);
//            }
//        }
//    }

//    @EventHandler
//    public void onEntityTeleport(EntityTeleportEvent event)
//    {
//        Bukkit.broadcastMessage("loud noises");
//        Entity entity = event.getEntity();
//        World world = entity.getWorld();
//        Bukkit.broadcastMessage(entity.getType().toString() + world.getName());
//    }
}
