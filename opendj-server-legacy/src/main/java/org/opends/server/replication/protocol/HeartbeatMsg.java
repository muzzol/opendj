/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2008 Sun Microsystems, Inc.
 * Portions Copyright 2013-2014 ForgeRock AS.
 */
package org.opends.server.replication.protocol;

import java.util.zip.DataFormatException;

/**
 * This message is sent at regular intervals by the replication server
 * when it is sending no other messages.  It allows the directory server to
 * detect a problem sooner when a synchronization server has crashed or has
 * been isolated from the network.
 */
public class HeartbeatMsg extends ReplicationMsg
{
  /**
   * Create a new HeartbeatMsg.
   *
   */
  public HeartbeatMsg()
  {
  }

  /**
   * Creates a new heartbeat message from its encoded form.
   *
   * @param in The byte array containing the encoded form of the message.
   * @throws java.util.zip.DataFormatException If the byte array does not
   * contain a valid encoded form of the message.
   */
  HeartbeatMsg(byte[] in) throws DataFormatException
  {
    /* The heartbeat message is encoded in the form :
     * <msg-type>
     */
    if (in.length != 1 || in[0] != MSG_TYPE_HEARTBEAT)
    {
      throw new DataFormatException("Input is not a valid Heartbeat Message.");
    }
  }

  /** {@inheritDoc} */
  @Override
  public byte[] getBytes(short protocolVersion)
  {
    /*
     * The heartbeat message contains:
     * <msg-type>
     */
    return new byte[] { MSG_TYPE_HEARTBEAT };
  }

  /** {@inheritDoc} */
  @Override
  public String toString()
  {
    return getClass().getSimpleName();
  }
}
