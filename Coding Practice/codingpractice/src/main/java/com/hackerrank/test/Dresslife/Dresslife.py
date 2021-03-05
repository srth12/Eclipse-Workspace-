# Final tech round

# 1. Find the common words that can see in both the title and the body (ex: et): []
#
# 2. Find all the unique words in the body :
# 3. Retry mechanism with exponential pausing



# Sample input

{
	"userId": 1,
	"id": 4,
	"title": "eum et est occaecati",
	"body": "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit"
}


# -------------  -------------      -------------    -------------

from collections import defaultdict
import json

class DresslifeResponseParser:

	def __init__(self) -> None:
		pass

	'''
    get_common_words prints the common words... # TODO
    Args:
        title: title, type- string
        body:  response body, type -string

        Return : None
    '''
	def print_common_words(self, title, body):
		title_word_set = set()

		for word in title.split(" "):  # should use regression to chech for multiple white spaces
			title_word_set.add(word)

		for word in body.split(" "):
			if title_word_set.__contains__(word):  # remove __contains__
				print("Duplicate word found - ", word)


	def print_all_unique_words(self, body):
		word_count_tracker = defaultdict(int)

		for word in body.split(" "):
			word_count = word_count_tracker[word]   # if key not present retuns 0 count
			word_count_tracker[word] = word_count + 1

		for word, word_count in word_count_tracker.items():
			if word_count == 1:
				print("Unique word found: ", word)



# Should have written seperate test file
if __name__ == "__main__":

	sample_input = '''
        {
          "userId": 1,
          "id": 4,
          "title": "eum et est occaecati",
          "body": "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit"
        }
    '''
	print(sample_input)
	json_dict = json.loads(sample_input)
	response_parser = DresslifeResponseParser()
	response_parser.print_common_words(json_dict["title"], json_dict["body"])





