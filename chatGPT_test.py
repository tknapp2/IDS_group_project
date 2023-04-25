import openai
import sys

question = " ".join(sys.argv[1:])

openai.api_key = "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"

response = openai.ChatCompletion.create(
  model="gpt-3.5-turbo",
  messages=[
        {"role": "system", "content": "You are an assistant that responds with just a classification of a question and nothing else."},
        {"role": "user", "content": "I want to train my legs for 90 minutes. Respond with one of the following five general categories: routine, exercise, alternative, muscle, and greeting; followed by a more specific category that decribes what kind of general category. For routine, this will be: arms, shoulders, chest, legs, chest and arms, core, full body, or back. Additionally, for ONLY routine, also respond with the amount of minutes the user gives. For example, if they ask about working out chest and arms for an hour, respond with routine: chest and arms, 60 . For exercise, this will be a specific exercise they are asking about, like lying dumbbell external shoulder rotation, dumbbell rear delt row, barbell upright row, etc. Additionally, if they ask about a specific muscle to work out, you will respond with a relevant exercise. For example, if they ask that they want to work out their biceps, you might respond with exercise: dumbbell curl . For alternative, you will respond with another exercise that targets the same muscles. For example, if the user asks for an alternative to bench press, you will respond with something like alternative: push up . For muscle, you respond simply with what exercise they are asking about, and not the muscle group. For example, if they ask what muscles does a push up work out, simply respond with muscle: push up . For greeting, this will always just be greeting. Do not add any extra punctuation and make everything lower case. For the exercise, alternative, and muscle categories, the exercise returned must be on this list, and written exactly like it is on this list: Bar Dip, Bench Press, Cable Chest Press, Close-Grip Bench Press, Close-Grip Feet-Up Bench Press, Decline Bench Press, Dumbbell Chest Fly, Dumbbell Chest Press, Dumbbell Decline Chest Press, Dumbbell Floor Press, Dumbbell Pullover, Feet-Up Bench Press, Floor Press, Incline Bench Press, Incline Dumbbell Press, Incline Push-Up, Kneeling Incline Push-Up, Kneeling Push-Up, Machine Chest Fly, Machine Chest Press, Pec Deck, Push-Up, Push-Up Against Wall, Push-Ups With Feet in Rings, Resistance Band Chest Fly, Smith Machine Bench Press, Smith Machine Incline Bench Press, Standing Cable Chest Fly, Standing Resistance Band Chest Fly, Band External Shoulder Rotation, Band Internal Shoulder Rotation, Band Pull-Apart, Barbell Front Raise, Barbell Rear Delt Row, Barbell Upright Row, Behind the Neck Press, Cable Lateral Raise, Cable Rear Delt Row, Dumbbell Front Raise, Dumbbell Horizontal Internal Shoulder Rotation, Dumbbell Horizontal External Shoulder Rotation, Dumbbell Lateral Raise, Dumbbell Rear Delt Row, Dumbbell Shoulder Press, Face Pull, Front Hold, Lying Dumbbell External Shoulder Rotation, Lying Dumbbell Internal Shoulder Rotation, Machine Lateral Raise, Machine Shoulder Press, Monkey Row, Overhead Press, Plate Front Raise, Power Jerk, Push Press, Reverse Dumbbell Flyes, Reverse Machine Fly, Seated Dumbbell Shoulder Press, Seated Barbell Overhead Press, Seated Smith Machine Shoulder Press, Snatch Grip Behind the Neck Press, Squat Jerk, Split Jerk, Barbell Curl, Barbell Preacher Curl, Bodyweight Curl, Cable Curl With Bar, Cable Curl With Rope, Concentration Curl, Dumbbell Curl, Dumbbell Preacher Curl, Hammer Curl, Incline Dumbbell Curl, Machine Bicep Curl, Spider Curl, Barbell Standing Triceps Extension, Barbell Lying Triceps Extension, Bench Dip, Close-Grip Push-Up, Dumbbell Lying Triceps Extension, Dumbbell Standing Triceps Extension, Overhead Cable Triceps Extension, Tricep Bodyweight Extension, Tricep Pushdown With Bar, Tricep Pushdown With Rope, Air Squat, Barbell Hack Squat, Barbell Lunge, Barbell Walking Lunge, Belt Squat, Body Weight Lunge, Box Squat, Bulgarian Split Squat, Chair Squat, Dumbbell Lunge, Dumbbell Squat, Front Squat, Goblet Squat, Hack Squat Machine, Half Air Squat, Hip Adduction Machine, Landmine Hack Squat, Landmine Squat, Leg Extension, Leg Press, Lying Leg Curl, Pause Squat, Romanian Deadlift, Safety Bar Squat, Seated Leg Curl, Shallow Body Weight Lunge, Side Lunges (Bodyweight), Smith Machine Squat, Squat, Step Up, Back Extension, Barbell Row, Barbell Shrug, Block Snatch, Cable Close Grip Seated Row, Cable Wide Grip Seated Row, Chin-Up, Clean, Clean and Jerk, Deadlift, Deficit Deadlift, Dumbbell Deadlift, Dumbbell Row, Dumbbell Shrug, Floor Back Extension, Good Morning, Hang Clean, Hang Power Clean, Hang Power Snatch, Hang Snatch, Inverted Row, Inverted Row with Underhand Grip, Kettlebell Swing, Lat Pulldown With Pronated Grip, Lat Pulldown With Supinated Grip, One-Handed Cable Row, One-Handed Lat Pulldown, Pause Deadlift, Pendlay Row, Power Clean, Power Snatch, Pull-Up, Rack Pull, Seal Row, Seated Machine Row, Snatch, Snatch Grip Deadlift, Stiff-Legged Deadlift, Straight Arm Lat Pulldown, Sumo Deadlift, T-Bar Row, Trap Bar Deadlift With High Handles, Trap Bar Deadlift With Low Handles, Banded Side Kicks, Cable Pull Through, Clamshells, Dumbbell Romanian Deadlift, Dumbbell Frog Pumps, Fire Hydrants, Frog Pumps, Glute Bridge, Hip Abduction Against Band, Hip Abduction Machine, Hip Thrust, Hip Thrust Machine, Hip Thrust With Band Around Knees, Lateral Walk With Band, Machine Glute Kickbacks, One-Legged Glute Bridge, One-Legged Hip Thrust , Romanian Deadlift, Single Leg Romanian Deadlift, Standing Glute Kickback in Machine, Step Up, Cable Crunch, Crunch, Dead Bug, Hanging Leg Raise, Hanging Knee Raise, Hanging Sit-Up, High to Low Wood Chop with Band, Horizontal Wood Chop with Band, Kneeling Ab Wheel Roll-Out, Kneeling Plank, Kneeling Side Plank, Lying Leg Raise, Lying Windshield Wiper, Lying Windshield Wiper with Bent Knees, Machine Crunch, Mountain Climbers, Oblique Crunch, Oblique Sit-Up, Plank, Side Plank, Sit-Up, Eccentric Heel Drop, Heel Raise, Seated Calf Raise, Standing Calf Raise, Barbell Wrist Curl, Barbell Wrist Curl Behind the Back, Bar Hang, Dumbbell Wrist Curl, Farmers Walk, Fat Bar Deadlift, Gripper, One-Handed Bar Hang, Plate Pinch, Plate Wrist Curl, Towel Pull-Up, Barbell Wrist Extension, Dumbbell Wrist Extension, Bench Press, Incline Dumbbell Press, Bar Dips, Standing Cable Chest Fly, Overhead Press, Seated Dumbbell Shoulder Press, Dumbbell Lateral Raise, Reverse Dumbbell Fly, Deadlift, Lat Pulldown, Pull-Up, Barbell Row, Dumbbell Row, Barbell Curl, Dumbbell Curl, Hammer Curl, Barbell Lying Triceps Extension, Overhead Cable Triceps Extension, Tricep Pushdown, Close-Grip Bench Press, Squat, Hack Squats, Leg Extension, Bulgarian Split Squat, Seated Leg Curl, Lying Leg Curl, Romanian Deadlift, Squat, Hip Thrust, Romanian Deadlift, Bulgarian Split Squat, Cable Crunch, Hanging Leg Raise, High to Low Wood Chop, Crunch, Standing Calf Raise, Seated Calf Raise. If an exercise asked about is not on this list, respond with none. Remember to get rid of all extra punctuation and to make everything lowercase."},
        {"role": "assistant", "content": "routine: legs"},
        {"role": "user", "content": question}
    ]
)

content = response["choices"][0]["message"]["content"]
print(content)

routine = 'Routine: Full Body,"Seated leg press (10 reps x 3 sets),Seated shoulder press (10 reps x 3 sets),Close grip lat pulldown (10 reps x 3 sets),Bodyweight lunges (10 reps x 3 sets),Full/kneeling press ups (10 reps x 3 sets),Plank (30 secs x 3),Leg raises (10 reps x 3 sets)"'
time = "20"
routine2 = 'Routine: Full Body,"Seated chest press (10 reps x 4 sets),Seated rows (10 reps x 4 sets),Wide grip lat pulldown (10 reps x 4 sets),Seated leg press (10 reps x 4 sets),Dumbbell seated shoulder press (10 reps x 4 sets),Dumbbell bicep curls (10 reps x 4 sets),Close grip tricep press ups (10 reps x 4 sets),Cable rotations/twists (10 reps x 4 sets),Reverse crunches (10 reps x 4 sets)"'
time2 = "60"
time3 = "10"

response2 = openai.ChatCompletion.create(
  model="gpt-3.5-turbo",
  messages=[
        {"role": "system", "content": "You are an assistant that expands or shrinks a given exercise routine to the desired amount of time. Every routine given will take around 40 minutes. You always respond in the same general way. Do not add any extra explaination."},
        {"role": "user", "content": routine + ", " + time + ". Your response should be formatted as three lists, the first being the exercise name, the second being the number of reps (or amount of seconds if relevent), and the third being the number of sets."},
        {"role": "assistant", "content": "[Seated leg press, Seated shoulder press, Close grip lat pulldown, Bodyweight lunges, Full/kneeling press ups, Plank, Leg raises], [8, 8, 8, 8, 8, 20, 8], [2, 2, 2, 2, 2, 2, 2]"},
        {"role": "user", "content": routine + ", " +  time2},
        {"role": "assistant", "content": "[Seated leg press, Seated shoulder press, Close grip lat pulldown, Bodyweight lunges, Full/kneeling press ups, Plank, Leg raises] [8, 8, 8, 8, 8, 20, 8], [4, 4, 4, 4, 4, 4, 4]"},
        {"role": "user", "content": routine2 + ", " +  time3}
    ]
)

print()
content2 = response2["choices"][0]["message"]["content"]
print(content2)
