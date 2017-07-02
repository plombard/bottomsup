package mq.lombard.bottomsup.resource;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/** @author Pascal Lombard */
@Path("/snoop")
public class Snoop {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response snoop(@Context ServletContext servletContext) {

    Map<String, Object> map = new HashMap<>();
    RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
    map.put("jvm.vendor", runtimeBean.getVmVendor());
    map.put("jvm.name", runtimeBean.getVmName());
    map.put("jvm.spec", runtimeBean.getSpecVersion());
    map.put("jvm.version", runtimeBean.getVmVersion());
    Instant startInstant = Instant.ofEpochMilli(runtimeBean.getStartTime());
    map.put(
        "jvm.started",
        LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault())
            .format(DateTimeFormatter.ISO_DATE_TIME));
    //map.put("jvm.properties", runtimeBean.getSystemProperties());
    MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
    map.put("heap.used", memoryBean.getHeapMemoryUsage().getUsed() / (1024 * 1024));
    map.put("heap.max", memoryBean.getHeapMemoryUsage().getMax() / (1024 * 1024));
    map.put("nonheap.used", memoryBean.getNonHeapMemoryUsage().getUsed() / (1024 * 1024));
    map.put("nonheap.max", memoryBean.getNonHeapMemoryUsage().getMax() / (1024 * 1024));
    OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
    map.put("os.name", osBean.getName());
    map.put("os.version", osBean.getVersion());
    map.put("os.arch", osBean.getArch());
    map.put("os.procs", osBean.getAvailableProcessors());
    map.put("os.load", osBean.getSystemLoadAverage());
    map.put("server.info", servletContext.getServerInfo());

    return Response.ok(map).type(MediaType.APPLICATION_JSON).build();
  }
}
