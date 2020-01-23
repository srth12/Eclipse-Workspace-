async def nats_publish():
    nc = NATS()

    await nc.connect(servers=["nats://localhost:4222"])

    await nc.publish("updates", b'All is Well')