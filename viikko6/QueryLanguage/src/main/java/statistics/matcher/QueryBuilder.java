package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    public Matcher build() {
        Matcher returnThis = this.matcher;
        this.matcher = new All();
        return returnThis;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String feature) {
        this.matcher = new And(matcher, new HasFewerThan(value, feature));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String feature) {
        this.matcher = new And(matcher, new HasAtLeast(value, feature));
        return this;
    }

    public QueryBuilder oneOf(Matcher matcherA, Matcher matcherB) {
        this.matcher = new And(matcher, new Or(matcherA, matcherB));
        return this;
    }

}
