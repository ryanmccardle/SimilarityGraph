package inout;

import datastructures.vo.Threshold;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import vo.Summary;

public class MyWriter {
    public static OpenOption APPEND_OPTIONS[] = new OpenOption[] { StandardOpenOption.WRITE,
            StandardOpenOption.APPEND };
    public static OpenOption OVERWRITE_OPTIONS[] = new OpenOption[] { StandardOpenOption.WRITE,
            StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING };

    public static boolean writeMultigraphSummary(Path outputFileName, Map<Integer, Summary> antNaboerTilSummary,
            List<Integer> numSimilarNeighborsPerNode) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName)) {
            writer.write("Number of neighbors\tNumber of nodes\tAccumulated sum\n");

            for (Entry<Integer, Summary> entry : antNaboerTilSummary.entrySet()) {
                final Summary summary = entry.getValue();
                writer.write(summary.getAntallNaboer() + "\t" + summary.getAntallNoder() + "\t"
                        + summary.getAkkumulertSum() + "\n");
            }

            writer.write("\n");
            writer.write("# similar neighbors for each node\n");
            for (int i = 0; i < numSimilarNeighborsPerNode.size(); i++) {
                writer.write(i + "\t" + numSimilarNeighborsPerNode.get(i) + "\n");
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean writeSettings(Path outputFileName, String inputFileName, Double prosent,
            Integer antNaboerEnvei, Integer cliqueSize, Integer absoluteValue, boolean append) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName,
                append ? APPEND_OPTIONS : OVERWRITE_OPTIONS)) {
            writer.append("Input filename\tPercentage\tNum neighbors one way\tClique size\tAbsolute value");
            writer.newLine();

            writer.append(inputFileName + "\t");
            writer.append(prosent + "\t");
            writer.append(antNaboerEnvei + "\t");
            writer.append(cliqueSize + "\t");
            writer.append(absoluteValue + "");
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean writeTabularHeader(Path outputFileName, int maxNeighbors) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName, OVERWRITE_OPTIONS)) {
            writer.append("Input filename\t");

            writer.append("Percentage\t");
            writer.append("Num neighbors one way\t");
            writer.append("Clique size\t");
            writer.append("Absolute Value\t");

            writer.append("Num nodes\t");
            writer.append("Avg num equal neighbors\t");
            writer.append("Num connected components\t");
            writer.append("Num bridges\t");
            writer.append("Num missing edges between direct neighbors\t");
            writer.append("Num cliques\t");
            writer.append("Maximum edges\t");

            for (int i = maxNeighbors - 1; i >= 0; i--) {
                writer.append("Num nodes " + i + " neighbors\t");
            }

            writer.append("Input filepath");
            writer.newLine();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean writeTabularLine(Path outputFileName, String inputFileName, Double prosent,
            Integer antNaboerEnvei, Integer cliqueSize, Integer absoluteValue, Integer numCliques, Integer antallNoder,
            Double gjennomsnitt, Integer numConnectedComponents, Integer numBridges,
            Integer numMissingDirectRelationships, Map<Integer, Summary> antNaboerTilSummary,
            List<BigDecimal> localClusteringCoefficients, int maxNeighborsInAllFiles) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        Path inputPath = Paths.get(inputFileName);
        Integer maxEdges = antNaboerTilSummary.entrySet().size() - 1;

        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName, APPEND_OPTIONS)) {
            writer.append(inputPath.getFileName().toString() + "\t");

            writer.append(prosent + "\t");
            writer.append(antNaboerEnvei + "\t");
            writer.append(cliqueSize + "\t");
            writer.append(absoluteValue + "\t");

            writer.append(antallNoder + "\t");
            writer.append(gjennomsnitt + "\t");
            writer.append(numConnectedComponents + "\t");
            writer.append(numBridges + "\t");
            writer.append(numMissingDirectRelationships + "\t");
            writer.append(numCliques + "\t");
            writer.append(maxEdges + "\t");

            // Prepend with empty cells if has fewer max neighbors
            for (int i = 0; i < maxNeighborsInAllFiles - antNaboerTilSummary.entrySet().size(); i++) {
                writer.append("\t");
            }

            for (Entry<Integer, Summary> entry : antNaboerTilSummary.entrySet()) {
                Summary summary = entry.getValue();
                writer.append(summary.getAntallNoder() + "\t");
            }

            writer.append(inputPath.toString() + "\t");

            writer.newLine();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean writeResults(Path outputFileName, Integer numCliques, Integer antallNoder,
            Double gjennomsnitt, Integer numConnectedComponents, Integer numBridges,
            Integer numMissingDirectRelationships, boolean append) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName,
                append ? APPEND_OPTIONS : OVERWRITE_OPTIONS)) {
            writer.append(
                    "Num nodes\tAvg num equal neighbors\tNum connected components\tNum bridges\tNum missing edges between direct neighbours\tNum cliques");
            writer.newLine();

            writer.append(antallNoder + "\t");
            writer.append(gjennomsnitt + "\t");
            writer.append(numConnectedComponents + "\t");
            writer.append(numBridges + "\t");
            writer.append(numMissingDirectRelationships + "\t");
            writer.append(numCliques + "");

            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean writeShortSummary(Path outputFileName, Map<Integer, Summary> antNaboerTilSummary,
            List<BigDecimal> localClusteringCoefficients, boolean append) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName,
                append ? APPEND_OPTIONS : OVERWRITE_OPTIONS)) {
            writer.append("Number of neighbors\tNumber of nodes\tAccumulated sum\n");

            for (Entry<Integer, Summary> entry : antNaboerTilSummary.entrySet()) {
                Summary summary = entry.getValue();
                writer.append(summary.getAntallNaboer() + "\t" + summary.getAntallNoder() + "\t"
                        + summary.getAkkumulertSum() + "\n");
            }

            writer.newLine();
            writer.append("Node\tLocal clustering coefficient\n");
            for (int i = 0; i < localClusteringCoefficients.size(); ++i) {
                writer.append(i + "\t" + localClusteringCoefficients.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean writeSummary(Path outputFileName, List<Integer> antallNaboerListe,
            Map<Integer, Summary> antNaboerTilSummary, boolean append) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName,
                append ? APPEND_OPTIONS : OVERWRITE_OPTIONS)) {
            for (int i = 0; i < antallNaboerListe.size(); ++i) {
                writer.write(antallNaboerListe.get(i) + "\n");
            }

            writer.write("\n");

            writer.write("Antall naboer\tAntall noder\tAkkumulert sum\n");

            for (Entry<Integer, Summary> entry : antNaboerTilSummary.entrySet()) {
                Summary summary = entry.getValue();
                writer.write(summary.getAntallNaboer() + "\t" + summary.getAntallNoder() + "\t"
                        + summary.getAkkumulertSum() + "\n");
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static <T extends Number> boolean writeStierMap(Path outputFileName, Map<Integer, List<T>> numEquals,
            List<Integer> tidsserie) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName, OVERWRITE_OPTIONS)) {

            writer.write("Pst");
            writer.write(";");
            for (int i = 0; i < tidsserie.size() - 1; ++i) {
                writer.write(String.valueOf(tidsserie.get(i)));
                writer.write(";");
            }
            writer.write(String.valueOf(tidsserie.get(tidsserie.size() - 1)));
            writer.write("\n");

            for (Entry<Integer, List<T>> entry : numEquals.entrySet().stream()
                    .sorted((x, y) -> x.getKey().compareTo(y.getKey())).collect(Collectors.toList())) {
                final Integer pst = entry.getKey();
                final List<T> counts = entry.getValue();

                writer.write(String.valueOf(pst));
                writer.write(";");
                for (int i = 0; i < counts.size() - 1; ++i) {
                    writer.write(String.valueOf(counts.get(i)));
                    writer.write(";");
                }
                writer.write(String.valueOf(counts.get(counts.size() - 1)));
                writer.write("\n");
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean writeDirectedNeighborhoodOutput(Path outputFileName,
            List<Integer> posSums, List<Integer> negSums, Double gjsnSumPos, Double gjsnSumNeg,
            Integer minSum, Integer maxSum, Integer minAbsoluteSum, Integer maxAbsoluteSum) {

        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName)) {
            writer.write("Absolutte summer: \n");
            for (int i = 0; i < posSums.size(); ++i) {
                writer.write(posSums.get(i) + "\n");
            }
            writer.write("Gjennomsnitt: " + gjsnSumPos + "\n");
            writer.write("Minimumssum:" + minAbsoluteSum + "\n");
            writer.write("Maksimumssum:" + maxAbsoluteSum + "\n");

            writer.write("\n");

            writer.write("Summer (som kan være negative): \n");
            for (int i = 0; i < negSums.size(); ++i) {
                writer.write(negSums.get(i) + "\n");
            }
            writer.write("Gjennomsnitt: " + gjsnSumNeg + "\n");
            writer.write("Minimumssum:" + minSum + "\n");
            writer.write("Maksimumssum:" + maxSum + "\n");
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean writeList(Path outputFileName, List<Integer> tall) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName)) {
            for (int i = 0; i < tall.size(); ++i) {
                writer.write(tall.get(i) + "\n");
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean writeIntArray(Path outputFileName, int[] tall) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName)) {
            for (int i = 0; i < tall.length; ++i) {
                writer.write(tall[i] + "\n");
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean write(Path outputFileName, List<List<Integer>> tidsserier) {
        try {
            Files.createDirectories(outputFileName.getParent());
        } catch (IOException ex) {
            return false;
        }
        StringBuilder sb = new StringBuilder("");
        try (BufferedWriter writer = Files.newBufferedWriter(outputFileName)) {
            int antallTall = tidsserier.get(1).size();
            int antallTidsserier = tidsserier.size();

            for (int prs = 1; prs <= 100; ++prs) {
                sb.append("Prs" + prs + "\t");
            }
            sb.append("\n");

            for (int tallIndex = 0; tallIndex < antallTall; ++tallIndex) {
                for (int i = 1; i < antallTidsserier; ++i) {
                    sb.append(tidsserier.get(i).get(tallIndex) + "\t");
                }
                sb.append("\n");
            }
            writer.write(sb.toString());
        } catch (IOException ex) {
            return false;
        }

        return true;
    }

}
