package fr.hugob147.endorialobby.shop;

public enum ShopItems {

    MiniVIP(1, "§aMini-Vip", 50000, "");

    private int id;
    private String name;
    private int prix;
    private String permission;

    ShopItems(int id, String name, int prix, String permission) {
        this.id = id;
        this.name = name;
        this.prix = prix;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrix() {
        return prix;
    }

    public String getPermission() {
        return permission;
    }

    public boolean hasPermission(){
        return permission.length() > 0;
    }

}
