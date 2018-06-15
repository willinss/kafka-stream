package processorapi;

/**
 * Created by williamguan on 2018/6/11.
 */

//stream version 1.1.0

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.ProcessorSupplier;

import java.util.Locale;
import java.util.Properties;
public class MyProcessorImp {
/*
    private static class MyProcessorSupplier implements ProcessorSupplier<String, String> {


        @Override
        public Processor<String, String> get() {
            return new Processor<String, String>() {
                private ProcessorContext context;
                private KeyValueStore<String, Integer> kvStore;

                @Override
                @SuppressWarnings("unchecked")
                public void init(ProcessorContext context) {
                    this.context = context;
                    this.context.schedule(1000);
                    this.kvStore = (KeyValueStore<String, Integer>) context.getStateStore("Counts");
                }

                @Override
                public void process(String dummy, String line) {
                    String[] words = line.toLowerCase(Locale.getDefault()).split(" ");

                    for (String word : words) {
                        Integer oldValue = this.kvStore.get(word);
                        System.out.println("get [" + word + "] has appeared [" + oldValue + "] times");
                        if (oldValue == null) {
                            this.kvStore.put(word, 1);
                        } else {
                            this.kvStore.put(word, oldValue + 1);
                        }
                    }

                    context.commit();
                }

                @Override
                public void punctuate(long timestamp) {
                    try (KeyValueIterator<String, Integer> iter = this.kvStore.all()) {
                        System.out.println("----------- " + timestamp + " ----------- ");

                        while (iter.hasNext()) {
                            KeyValue<String, Integer> entry = iter.next();

                            System.out.println("[" + entry.key + ", " + entry.value + "]");

                            context.forward(entry.key, entry.value.toString());
                        }
                    }
                }

                @Override
                public void close() {
                    this.kvStore.close();
                }
            };
        }
    }*/

    public static void main(String[] args) throws Exception {
        String ipPort = args[0];
        Properties props = new Properties();
        props.put(StreamsConfig.CLIENT_ID_CONFIG, "instance-will");
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, ipPort);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        Topology builder = new Topology();
        builder.addSource("Source", "in");
/*
        builder.addProcessor("Process", new ProcessorSupplier(), "Source");
        builder.addStateStore(Stores.create("Counts").withStringKeys().withIntegerValues().inMemory().build(), "Process");
        builder.addSink("Sink", "out", "Process");

        KafkaStreams streams = new KafkaStreams(builder, props);
        streams.start();

        // usually the stream application would be running forever,
        // in this example we just let it run for some time and stop since the input data is finite.
        Thread.sleep(5000L);

        streams.close();*/


    }
}