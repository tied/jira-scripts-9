// Adds a group of watchers to issue at a certain event (e. g. IssueCreated)
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.issue.Issue;

def userManager = ComponentAccessor.getUserManager()
def groupManager = ComponentAccessor.getGroupManager()
def watcherManager = ComponentAccessor.getWatcherManager()

def issue = event.getIssue()
def group = groupManager.getUsersInGroup('groupname')

for (elem in group){
    def username = ''
    for (int i = 0; i < elem.toString().length(); i++){
        def character = elem.toString().charAt(i)
        if (character == '(')
        	break
        username = username.toString() + character.toString()
    }
    def user = userManager.getUserByName(username)
    watcherManager.startWatching(user, issue)
}
