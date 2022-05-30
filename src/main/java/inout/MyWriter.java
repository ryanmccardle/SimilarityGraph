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
    public static OpenOption APPEND_OPTIONS[] = new OpenOption[] {StandardOpenOption.WRITE, StandardOpenOption.APPEND};
    public static OpenOption OVERWRITE_OPTIONS[] = new OpenOption[] {StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING};
    
    public static boolean writeMultigraphSummary(String fileName, Map<Integer,Summary> antNaboerTilSummary, List<Integer> numSimilarNeighborsPerNode) {
        final Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Number of neighbors\tNumber of nodes\tAccumulated sum\n");
            
            for (Entry<Integer,Summary> entry : antNaboerTilSummary.entrySet()) {
                final Summary summary = entry.getValue();
                writer.write(summary.getAntallNaboer() + "\t" + summary.getAntallNoder() + "\t" + summary.getAkkumulertSum() + "\n");
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
    
    public static boolean writeSettings(String outputFileName, String inputFileName, Double prosent, Integer antNaboerEnvei, Integer cliqueSize, boolean append) {
        Path path = Paths.get(outputFileName);
        
        try (BufferedWriter writer = Files.newBufferedWriter(path, append?APPEND_OPTIONS:OVERWRITE_OPTIONS)) {   
            writer.append("Input filename\tPercentage\tNum neighbors one way\tClique size\tAbsolute value");
            writer.newLine();
            
            writer.append(inputFileName + "\t");
            writer.append(prosent + "\t");
            writer.append(antNaboerEnvei + "\t");
            writer.append(cliqueSize + "");
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            return false;
        }
        
        return true;
    }
    
                    // Update text fields
                //numCliquesTextField.setText(numCliquesTextField.getText() + String.valueOf(algorithim.getNumberOfCliques(cliqueSize)) + ";");
                //antallNoderTextField.setText(antallNoderTextField.getText() + algorithim.getNumNodes().toString() + ";");
                //gjennomsnitttextField.setText(gjennomsnitttextField.getText() + algorithim.getAverage().toString() + ";");
                //numConnectedComponentsTextField.setText(numConnectedComponentsTextField.getText() + algorithim.getNumConnectedComponents().toString() + ";");
                //numBridgesTextField.setText(numBridgesTextField.getText() + algorithim.getNumBridges().toString() + ";");
                //umMissingDirectRelationshipsTextField.setText(numMissingDirectRelationshipsTextField.getText() + algorithim.getNumMissingDirectNeighborRelationships().toString() + ";");
                
    public static boolean writeResults(String outputFileName, Integer numCliques, Integer antallNoder, Double gjennomsnitt, Integer numConnectedComponents, Integer numBridges, Integer numMissingDirectRelationships,  boolean append) {
        Path path = Paths.get(outputFileName);
        
        try (BufferedWriter writer = Files.newBufferedWriter(path, append?APPEND_OPTIONS:OVERWRITE_OPTIONS)) {            
            writer.append("Num nodes\tAvg num equal neighbors\tNum connected components\tNum bridges\tNum missing edges between direct neighbours\tNum cliques");
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
    
    
    public static boolean writeShortSummary(String fileName, Map<Integer,Summary> antNaboerTilSummary, List<BigDecimal> localClusteringCoefficients, boolean append) {
        Path path = Paths.get(fileName);
 
        try (BufferedWriter writer = Files.newBufferedWriter(path, append?APPEND_OPTIONS:OVERWRITE_OPTIONS)) {
            writer.append("Number of neighbors\tNumber of nodes\tAccumulated sum\n");
            
            for (Entry<Integer,Summary> entry : antNaboerTilSummary.entrySet()) {
                Summary summary = entry.getValue();
                writer.append(summary.getAntallNaboer() + "\t" + summary.getAntallNoder() + "\t" + summary.getAkkumulertSum() + "\n");
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
    
    public static boolean writeSummary(String fileName, List<Integer> antallNaboerListe, Map<Integer,Summary> antNaboerTilSummary, boolean append) {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, append?APPEND_OPTIONS:OVERWRITE_OPTIONS)) {   
            for (int i = 0; i < antallNaboerListe.size(); ++i) {
                writer.write(antallNaboerListe.get(i) + "\n");
            }
            
            writer.write("\n");
            
            writer.write("Antall naboer\tAntall noder\tAkkumulert sum\n");
            
            for (Entry<Integer,Summary> entry : antNaboerTilSummary.entrySet()) {
                Summary summary = entry.getValue();
                writer.write(summary.getAntallNaboer() + "\t" + summary.getAntallNoder() + "\t" + summary.getAkkumulertSum() + "\n");
            }
        } catch (IOException e) {
            return false;
        }
        
        return true;
    }
    
    public static <T extends Number> boolean writeStierMap(String fileName, Map<Integer, List<T>> numEquals, List<Integer> tidsserie) {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, OVERWRITE_OPTIONS)) { 
            
            writer.write("Pst");
            writer.write(";");
            for (int i = 0; i < tidsserie.size() - 1; ++i) {
                writer.write(String.valueOf(tidsserie.get(i)));
                writer.write(";");
            }
            writer.write(String.valueOf(tidsserie.get(tidsserie.size()-1)));
            writer.write("\n");
            
            for (Entry<Integer, List<T>> entry : numEquals.entrySet().stream().sorted((x,y) -> x.getKey().compareTo(y.getKey())).collect(Collectors.toList())) {
                final Integer pst = entry.getKey();
                final List<T> counts = entry.getValue();
                
                writer.write(String.valueOf(pst));
                writer.write(";");
                for (int i = 0; i < counts.size() - 1; ++i) {
                    writer.write(String.valueOf(counts.get(i)));
                    writer.write(";");
                }
                writer.write(String.valueOf(counts.get(counts.size()-1)));
                writer.write("\n");
            }
        } catch (IOException e) {
            return false;
        }
        
        return true;
    }
    
    public static boolean writeDirectedNeighborhoodOutput(String fileName, 
            List<Integer> posSums, List<Integer> negSums, Double gjsnSumPos, Double gjsnSumNeg,
            Integer minSum, Integer maxSum, Integer minAbsoluteSum, Integer maxAbsoluteSum) {
        
        
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {  
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
    
    public static boolean writeList(String fileName, List<Integer> tall) {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {   
            for (int i = 0; i < tall.size(); ++i) {
                writer.write(tall.get(i) + "\n");
            }
        } catch (IOException e) {
            return false;
        }
        
        return true;
    }
    
    public static boolean writeIntArray(String fileName, int[] tall) {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {   
            for (int i = 0; i < tall.length; ++i) {
                writer.write(tall[i] + "\n");
            }
        } catch (IOException e) {
            return false;
        }
        
        return true;
    }

    public static boolean write(String fileName, List<List<Integer>> tidsserier) {
        Path path = Paths.get(fileName);
        StringBuilder sb = new StringBuilder("");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {   
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
