import argparse
from bs4 import BeautifulSoup

#test class
class ServiceFunnel:
    def __init__(self):
        self._key_snippets_map = dict()

    def scrape_html(self, html: str):
        """
        Scrape HTML, extract tags and snippet and store them in an appropriate data structure.
        
        Args:
            html (str) : Entire HTML content. Not the path to HTML document.
        """

        snippet = Snippet(html)
        for key in snippet.keys:
            if key not in self._key_snippets_map:
                self._key_snippets_map[key] = set()
            self._key_snippets_map[key].add(snippet)

    def handle_request(self, request: dict) -> dict:
        """
        Find out the correct snippet that maps to a set of input tags.
        
        Args:
            request (dict): Request object as specified in the readme.
        Returns:
            response (dict): Response object as specified in the readme.
        """

        intersected_snippet = None
        request_key_set = set()
        for element in request['selected_tags']:
            snippets_set = self._key_snippets_map.get(element['name'], set())
            request_key_set.add(element['name'])
            if intersected_snippet is None:
                intersected_snippet = snippets_set
            else:
                intersected_snippet = intersected_snippet.intersection(snippets_set)
        return self.compose_result(intersected_snippet, request, request_key_set)

    def compose_result(self, interset_snippet: set, request: dict, request_key_set: set) -> dict:
        """
        Find out the correct snippet that maps to a set of input tags and form the result

        Args:
            interset_snippet (set):  set of snippets with the matching keys
            request (dict): Request object as specified in the readme.
            request_key_set (set): set of keys in the request
        Returns:
            response (dict): Response object as specified in the readme.
        """

        result = dict()
        tag_count_in_req = len(request['selected_tags'])

        if len(interset_snippet) == 0:
            result['snippet'] = 'null'
            result['next_tags'] = []
            msg = {"code" : 2, "msg": "Invalid tags"}
            result['status'] = msg
            result['selected_tags'] = request['selected_tags']
            return result

        elif len(interset_snippet) == 1:
            snippet = interset_snippet.pop()
            result['snippet'] = snippet.article
            msg = {"code" : 0, "msg": "Valid tags with snippet"},
            result['status'] = msg
            result['selected_tags'] = request['selected_tags']
            if len(snippet.keys) == tag_count_in_req:
                result['next_tags'] = []
                return result
            else:
                missing_keys = request_key_set.symmetric_difference(snippet.keys)
                result['next_tags'] = list(missing_keys)
                return result
        else:
            msg = {"code" : 1, "msg": "Valid tags but no snippet"}
            result['status'] = msg
            result['snippet'] = 'null'
            result['selected_tags'] = request['selected_tags']
            disjoint_key_set = set()
            for snipp in interset_snippet:
                disjoint_key_set.difference(snipp.keys)

            result['next_tags'] = list(disjoint_key_set)
            return result

class Snippet:
    def __init__(self, article):
        self._article = article
        soup = BeautifulSoup(article, 'html.parser')
        article_link = soup.find('article')
        val = article_link.attrs['data-tags']
        val = val.split(', ')
        self._keys = set(val)

    @property
    def article(self):
        return self._article

    @property
    def keys(self):
        return self._keys

    def add_key(self, key):
        self.keys.add(key)

    def get_all_keys(self):
        return self.keys

    def __eq__(self, other):
        if self.article == other.article:
            return True
        else:
            return False

    def __hash__(self):
        return hash(self.article)


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument(
        "--html_path",
        help="path leading to the html file",
        type=str,
        required=True,
    )
    args = parser.parse_args()
    with open(args.html_path, "r") as f:
        html_str = f.read()
    service_funnel = ServiceFunnel()
    service_funnel.scrape_html(html_str)
    request = {"selected_tags": [{"name": "Widerruf"}, {"name": "Mobilfunkvertrag"}]}
    service_funnel.handle_request(request)
