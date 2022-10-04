package pl.sii.streams;

import java.util.Objects;

public class DataRecord {
    private final String round;
    private final String indicator;
    private final String group;
    private final String subgroup;
    private final long sampleSize;
    private final String response;
    private final double percent;
    private final double standardError;
    private final double suppression;
    private final double significant1;
    private final double significant2;

    public DataRecord(String round, String indicator, String group, String subgroup, long sampleSize, String response,
                      double percent, double standardError, double suppression, double significant1, double significant2) {
        this.round = round;
        this.indicator = indicator;
        this.group = group;
        this.subgroup = subgroup;
        this.sampleSize = sampleSize;
        this.response = response;
        this.percent = percent;
        this.standardError = standardError;
        this.suppression = suppression;
        this.significant1 = significant1;
        this.significant2 = significant2;
    }

    public String getRound() {
        return round;
    }

    public String getIndicator() {
        return indicator;
    }

    public String getGroup() {
        return group;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public long getSampleSize() {
        return sampleSize;
    }

    public String getResponse() {
        return response;
    }

    public double getPercent() {
        return percent;
    }

    public double getStandardError() {
        return standardError;
    }

    public double getSuppression() {
        return suppression;
    }

    public double getSignificant1() {
        return significant1;
    }

    public double getSignificant2() {
        return significant2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRecord that = (DataRecord) o;
        return sampleSize == that.sampleSize && Double.compare(that.percent, percent) == 0 && Double.compare(that.standardError, standardError) == 0 && Double.compare(that.suppression, suppression) == 0 && Double.compare(that.significant1, significant1) == 0 && Double.compare(that.significant2, significant2) == 0 && Objects.equals(round, that.round) && Objects.equals(indicator, that.indicator) && Objects.equals(group, that.group) && Objects.equals(subgroup, that.subgroup) && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, indicator, group, subgroup, sampleSize, response, percent, standardError, suppression, significant1, significant2);
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "round='" + round + '\'' +
                ", indicator='" + indicator + '\'' +
                ", group='" + group + '\'' +
                ", subgroup='" + subgroup + '\'' +
                ", sampleSize=" + sampleSize +
                ", response='" + response + '\'' +
                ", percent=" + percent +
                ", standardError=" + standardError +
                ", suppression=" + suppression +
                ", significant1=" + significant1 +
                ", significant2=" + significant2 +
                '}';
    }
}
