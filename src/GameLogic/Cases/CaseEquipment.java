package GameLogic.Cases;

import Characters.Character;
import Enum.EnumType;
import Equipements.Equipment;
import Equipements.EquipmentFactory;
import GameLogic.Menu;

public class CaseEquipment  implements Case{

    private Menu menu;

    public CaseEquipment(Menu menu) {
        this.menu = menu;
    }
    @Override
    public void interaction(Character playerChar){
        if (playerChar.getType().equals(EnumType.mage)){
            Equipment equipment = EquipmentFactory.createRandomMageEquipment();
            assert equipment != null;
            System.out.println("You enter a new room, on a dark shrine in front of you there is "+equipment.getEquipementDesc());

            menu.equipmentInteractionMenu(equipment);
        }else{
            Equipment equipment = EquipmentFactory.createRandomWarEquipment();
            assert equipment != null;
            System.out.println("You enter a new room, on a dark shrine in front of you there is "+equipment.getEquipementDesc());
            menu.equipmentInteractionMenu(equipment);
        }
    }
}
