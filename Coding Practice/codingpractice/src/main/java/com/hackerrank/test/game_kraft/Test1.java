//Scratch Card System
//        1. start time and end time -> scratch card should appear after after x interval of mins
//        2. pool of rewards -
//        [{10:1000, 5: 20000, 50:100, Missed: unlimited}]
//        [{10:20, 5:50, 50: 2, Missed: 25}]
//        1 user can have 1 reward from a pool
//        10 - 4 and each scratch card is presented after 2 hours
//        4 scratches person can do, max time he can actually earn a reward is a number - 2
//
//        claim -> user has scratched
//        -----------------------------------
//        Types of Scrath card ->
//
//        POST /scratch/
//        {
//        "user_id":
//        }
//
//
//
//        Objects
//        1. screatch_card
//        2. user
//        3. user_scratch_card_map
//
//        Table:
//        1. user - user_id, user_name,
//
//        2. screatch_card - scratch_card_id, amount, available_pool, weightage, generated_time, end_time, availability_interval
//
//        3. user_scratch_card_map - user_id, scratch_card_id, scratched_time
//
//        Classes:
//
//        1. User:
//        - userId: Long
//        - userName: String
//
//        + getUserId()
//
//        2. ScratchCard:
//        - scratchCardId: Long
//        - amount: Double
//        - availablePool: Long
//        - weightage: Double
//        - generatedTime: TimeStamp
//
//
//        APIs:
//        1. scratch API
//
//        POST /scratch/
//        {
//        "user_id": <user_id>,
//        "screatch_Card_id":<screatch card type>
//        }
//
//
//        response:
//
//        Format: Json
//        {
//        "user_id",
//        ""
//        }
//
//
//        Steps:
//        1. Post request
//        2. Lookup user_scratch_card_map -> userid, timestamp:
//        Query for scratched stamps from DB -> get all screatch card used by user entire day
//
//        timestamp:
//        a) Used stamps:
//        At 5:30 -> retrun error
//        10:00, 4:00 PM <- 5.30
//
//        Allowted Quota ->
//        generated_time, end_time, availability_interval
//
//        11:30 ->
//        10:00: 10:00 +2
//        [generated_time: generated_time + availability_interval]
//
//        12.30
//
//        [generated_time + availability_interval: generated_time + 2 * availability_interval]
//
//        n = (current_time - generated_time ) / availability_interval
//
//
//
//        unused_scratch_card - List
//        1 -> 5rs
//        10 -> 5rs, 1rs - 1900 20 request
//        3. Algo to select the screatchcard from the unused list:
//
//
//        total weight -> 87
//        0-19 > 10
//        20 - 69 > 5
//        x - 87 >
//        index = floor(Math.rangd()* total_weight )
//        [0-1]*87  -> 87 -> 5 rs
//
//
//        4. After selecting the scratch card
//        update the table   'user_scratch_card_map', 'screatch_card'
//
//
//
//
//        [{10:1000, 5: 20000, 50:100, Missed: unlimited}]
//        [{10:20, 5:50, 50: 2, Missed: 25}]
//        1 user can have 1 reward from a pool
//        10 - 4 and each scratch card is presented after 2 hours
//        4 scratches person can do, max time he can actually earn a reward is a number - 2
//
//
//
//
//
//
//