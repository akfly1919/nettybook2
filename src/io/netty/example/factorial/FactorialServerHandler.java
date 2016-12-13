/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.example.factorial;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.math.BigInteger;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handler for a server-side channel.  This handler maintains stateful
 * information which is specific to a certain channel using member variables.
 * Therefore, an instance of this handler can cover only one channel.  You have
 * to create a new handler instance whenever you create a new channel and insert
 * this handler  to avoid a race condition.
 */
public class FactorialServerHandler extends SimpleChannelInboundHandler<BigInteger> {

    private static final Logger logger = Logger.getLogger(
            FactorialServerHandler.class.getName());

    private BigInteger lastMultiplier = new BigInteger("1");
    private BigInteger factorial = new BigInteger("1");

    @Override
    public void messageReceived(ChannelHandlerContext ctx, BigInteger msg) throws Exception {
        // Calculate the cumulative factorial and send it to the client.
    	logger.info("server-->"+msg);
        lastMultiplier = msg;
        factorial = factorial.multiply(msg);
        ctx.writeAndFlush(factorial);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Formatter fmt = new Formatter();
        logger.info(fmt.format(
                "Factorial of %,d is: %,d", lastMultiplier, factorial).toString());
        fmt.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.log(
                Level.WARNING,
                "Unexpected exception from downstream.", cause);
        ctx.close();
    }
}
