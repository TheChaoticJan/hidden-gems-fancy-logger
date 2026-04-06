package logger;

import java.util.ArrayList;
import java.util.List;

public class Logger
{
    private final int consoleHeight;

    private final List<String> mapLogs = new ArrayList<>();
    private final List<String> pathLogs = new ArrayList<>();
    private final List<String> signalLogs = new ArrayList<>();
    private final List<String> genericLogs = new ArrayList<>();

    public Logger(int consoleHeight)
    {
        /*
        consoleHeight is the height of the map.
         */
        this.consoleHeight = consoleHeight;
    }

    public void addMapLog(String log)
    {
        mapLogs.add("\uD83D\uDCCD " + log);
    }

    public void addPathLog(String log)
    {
        pathLogs.add("⚑ " + log);
    }

    public void addSignalLog(String log)
    {
        signalLogs.add("\uD83D\uDCE1 " + log);
    }

    public void addGenericLog(String log)
    {
        genericLogs.add("ⓘ  " + log);
    }

    public void sendLog()
    {
        boolean isFull = false;
        //priority in logging (because of the cap of the console height) :
        //  generic > signal > map > path
        //This priority literally just comes from the experience I had with debugging those aspects
        StringBuilder builder = new StringBuilder();

        builder.append("------[ Generic ]-----------------------\n");
        builder.append("\n");
        int length = 2;

        for(String message : genericLogs)
        {
            builder.append(message).append("\n");
            length++;
            if(length >= consoleHeight - 1)
            {
                isFull = true;
                break;
            }
        }
        if(!isFull)
        {
            builder.append("\n");
            length++;
        }
        if(length >= consoleHeight - 1) isFull = true;
        if(!isFull)
        {
            builder.append("------[ Signal ]------------------------\n");
            length++;
        }
        if(length >= consoleHeight - 1) isFull = true;
        if(!isFull)
        {
            builder.append("\n");
            length++;
        }
        if(length >= consoleHeight - 1) isFull = true;

        if(!isFull)
        {
            for(String message : signalLogs)
            {
                builder.append(message).append("\n");
                length++;
                if(length >= consoleHeight - 1)
                {
                    isFull = true;
                    break;
                }
            }
        }
        if(!isFull)
        {
            builder.append("\n");
            length++;
        }
        if(length >= consoleHeight - 1) isFull = true;
        if(!isFull)
        {
            builder.append("------[ Map ]---------------------------\n");
            length++;
        }
        if(length >= consoleHeight - 1) isFull = true;
        if(!isFull)
        {
            builder.append("\n");
            length++;
        }
        if(length >= consoleHeight - 1) isFull = true;

        if(!isFull)
        {
            for(String message : mapLogs)
            {
                builder.append(message).append("\n");
                length++;
                if(length >= consoleHeight - 1)
                {
                    isFull = true;
                    break;
                }
            }
        }
        if(!isFull)
        {
            builder.append("\n");
            length++;
        }
        if(length >= consoleHeight - 1) isFull = true;
        if(!isFull)
        {
            builder.append("------[ Path ]--------------------------\n");
            length++;
        }
        if(length >= consoleHeight - 1) isFull = true;
        if(!isFull)
        {
            builder.append("\n");
            length++;
        }
        if(length >= consoleHeight - 1) isFull = true;

        if(!isFull)
        {
            for(String message : pathLogs)
            {
                builder.append(message).append("\n");
                length++;
                if(length >= consoleHeight - 1)
                {
                    break;
                }
            }
        }

        builder.append(" \n ".repeat(Math.max(0, consoleHeight - 1 - length)));

        System.err.println(builder);
    }
}
