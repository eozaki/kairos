public class ArgValidator
{
    private final int port;
    private final int max_clients;
    private final int max_threads;

    public ArgValidator(String[] args)
    {
        if(args.length < 4)
            throw new RuntimeException("Missing args: IP port maxclients maxthreads");

        parseIP( args[0] );
        this.port = parseIntValue( args[1], "port", 0, 65535 );
        this.max_clients = parseIntValue( args[2], "max clients", 1, 99999 );
        this.max_threads = parseIntValue( args[3], "max threads", 1, 99999 );

    }

    private void parseIP(String ip)
    {
        if( ip == null || ip.isEmpty() )
            throw new IllegalArgumentException("Arg validation: Invalid IP \"" + ip + "\"");
    }

    private static int parseIntValue(String arg_string, String arg_name, int min_bound, int max_bound)
    {
        int _value;

        try{
            _value = Integer.parseInt(arg_string);
        }
        catch( NumberFormatException e )
        {
            throw new IllegalArgumentException("Arg validation: Invalid value \"" + arg_string + "\" for argument \"" + arg_name + "\"");
        }

        if(_value < min_bound || _value > max_bound )   //  (port < 49152 || port > 65535 )
        {
            throw new IllegalArgumentException("Arg validation: "+ arg_name +" out-of-range [" + min_bound + "-" + max_bound + "]");
        }

        return _value;
    }

    public int getPort(){
        return port;
    }

    public int getMaxClients(){
        return max_clients;
    }

    public int getMaxThreads(){
        return max_threads;
    }
}
