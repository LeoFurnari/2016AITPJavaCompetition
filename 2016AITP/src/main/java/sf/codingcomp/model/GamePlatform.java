package sf.codingcomp.model;

public enum GamePlatform implements Platform<Game> {
	LNX {
	},
	MAC {
	},
	PC {
	},
	PSP {
	},
	PS2 {
	},
	PS4 {
	},
	X {
	},
	X360 {
	},
	X1 {
	},
	WII {
	},
	WIIU {
	};

	@Override
	public boolean inStock(Game game) {
		switch (this.toString()) {
		case "LNX":
			return Integer.parseInt(game.getStockLnx()) > 0;
		case "MAC":
			return Integer.parseInt(game.getStockMac()) > 0;
		case "PC":
			return Integer.parseInt(game.getStockPc()) > 0;
		case "PS4":
			return Integer.parseInt(game.getStockPs4()) > 0;
		case "PS2":
			return Integer.parseInt(game.getStockPs2()) > 0;
		case "X":
			return Integer.parseInt(game.getStockX()) > 0;
		case "X360":
			return Integer.parseInt(game.getStockX360()) > 0;
		case "X1" :
			return Integer.parseInt(game.getStockX1()) > 0;
		case "PSP":
			return Integer.parseInt(game.getStockPsp()) > 0;
		case "WII":
			return Integer.parseInt(game.getStockWii()) > 0;
		case "WIIU":
			return Integer.parseInt(game.getStockWiiU()) > 0;
		}
		return false;
	}

	@Override
	public void checkout(Game game) {
		switch (this.toString()) {
		case "LNX":
			int p = Integer.parseInt(game.getStockLnx())-1;
			game.setStockLnx(p + "");
			break;
		case "MAC":
			int i = Integer.parseInt(game.getStockMac())-1;
			game.setStockMac(i + "");
			break;
			case "PC":
			int s = Integer.parseInt(game.getStockPc())-1;
			game.setStockPc(s + "");
			break;
		case "PS4":
			int e = Integer.parseInt(game.getStockPs4())-1;
			game.setStockPs4(e + "");
			break;
		case "PS2":
			int d = Integer.parseInt(game.getStockPs2())-1;
			game.setStockPs2(d + "");
			break;
		case "X":
			int o = Integer.parseInt(game.getStockX())-1;
			game.setStockX(o + "");
			break;
		case "X360":
			int f = Integer.parseInt(game.getStockX360())-1;
			game.setStockX360(f + "");
			break;
		case "X1" :
			int r = Integer.parseInt(game.getStockX1())-1;
			game.setStockX1(r + "");
			break;
		case "PSP":
			int n = Integer.parseInt(game.getStockPsp())-1;
			game.setStockPsp(n + "");
			break;
		case "WII":
			int m = Integer.parseInt(game.getStockWii())-1;
			game.setStockWii(m + "");
			break;
		case "WIIU":
			int a = Integer.parseInt(game.getStockWiiU())-1;
			game.setStockWiiU(a + "");
			break;
		}
	}

}
