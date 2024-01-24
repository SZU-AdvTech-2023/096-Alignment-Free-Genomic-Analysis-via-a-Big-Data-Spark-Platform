package fade.affunction;

import fade.AFFunctionEvaluatorByStatistic;
import fade.util.*;

public class Hellinger extends AFFunctionEvaluatorByStatistic {
    public Hellinger(Configuration conf) {
        super(conf);
    }

    @Override
    public AFValue evaluatePartialAFValue(Value s1, Value s2) {
        // 归一化
        double count1 = ((CountValue)s1).count * 1.0 / getCount1();
        double count2 = ((CountValue)s2).count * 1.0 / getCount2();

        return new AFValue(Math.pow(Math.sqrt(count1) - Math.sqrt(count2), 2));
    }

    @Override
    public AFValue combinePartialAFValues(AFValue d1, AFValue d2) {
        return new AFValue(d1.value + d2.value);
    }

    @Override
    public AFValue finalizeAFValue(AFValue d) {
        return new AFValue(Math.sqrt(d.value / 2));
    }
}
