package cartes;

public abstract class Carte {

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Carte autre = (Carte) obj;
		return toString().equals(autre.toString());

	}
}