package com.example.restservice;

public class SearchMap {
    private String string;
    private String symbol;

    SearchMap(String string, String symbol) {
        this.string = string;
        this.symbol = symbol;
    }

    public String getString() {
        return string;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (string == null ? 0 : string.hashCode());
        hash = 31 * hash + (symbol == null ? 0 : symbol.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SearchMap other = (SearchMap) obj;
        if (!string.equals(other.string))
            return false;
        if (!symbol.equals(other.symbol))
            return false;
        return true;
    }
}
