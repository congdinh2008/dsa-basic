#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

void traverse(struct Node* head);
void addFirst(struct Node** head_ref, int value);
void addLast(struct Node** head_ref, int value);
void addAfter(struct Node* prevNode, int value);
int getHead(struct Node* head);
int getTail(struct Node* head);
int getNodeByIndex(struct Node* head, int index);
void deleteFirst(struct Node** head_ref);
void deleteLast(struct Node** head_ref);
void deleteAtIndex(struct Node** head_ref, int index);
void deleteAfterNode(struct Node* prevNode);
void deleteByValue(struct Node** head_ref, int value);
void updateByIndex(struct Node** head_ref, int index, int value);

int main(int argc, char const* argv[]) {
    struct Node* head = NULL;
    struct Node* second = NULL;
    struct Node* third = NULL;
    struct Node* fourth = NULL;
    struct Node* fifth = NULL;

    head = (struct Node*)malloc(sizeof(struct Node));
    head->data = 3;
    head->next = NULL;

    second = (struct Node*)malloc(sizeof(struct Node));
    second->data = 4;
    second->next = NULL;
    head->next = second;

    third = (struct Node*)malloc(sizeof(struct Node));
    third->data = 5;
    third->next = NULL;
    second->next = third;

    fourth = (struct Node*)malloc(sizeof(struct Node));
    fourth->data = 6;
    fourth->next = NULL;
    third->next = fourth;

    fifth = (struct Node*)malloc(sizeof(struct Node));
    fifth->data = 7;
    fifth->next = NULL;
    fourth->next = fifth;

    printf("Traverse Linked List\n");
    traverse(head);

    addFirst(&head, 1);

    printf("\nLinked List after add 1 to first\n");
    traverse(head);

    addLast(&head, 8);

    printf("\nLinked List after add 8 to end\n");
    traverse(head);

    addAfter(head->next->next, 4);

    printf("\nLinked List after add 4 after the third\n");
    traverse(head);

    printf("\nHead of the linked list\n");
    printf("%d\n", getHead(head));

    printf("Tail of the linked list\n");
    printf("%d\n", getTail(head));

    printf("\nGet Node by index\n");
    printf("%d\n", getNodeByIndex(head, 5));

    deleteFirst(&head);

    printf("\nLinked List after delete first\n");
    traverse(head);

    deleteLast(&head);

    printf("\nLinked List after delete last\n");
    traverse(head);

    deleteAtIndex(&head, 2);

    printf("\nLinked List after delete at index 2\n");
    traverse(head);

    deleteAfterNode(head->next);

    printf("\nLinked List after delete after node\n");
    traverse(head);

    deleteByValue(&head, 4);

    printf("\nLinked List after delete by value\n");
    traverse(head);

    updateByIndex(&head, 2, 9);

    printf("\nLinked List after update by index\n");
    traverse(head);

    // Freeing memory
    struct Node* current = head;
    struct Node* next = NULL;
    while (current != NULL) {
        next = current->next;
        free(current);
        current = next;
    }

    return 0;
}

/// @brief Traverse a linked list
/// @param head The head of the linked list
void traverse(struct Node* head) {
    struct Node* current = head;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}

/// @brief Adds a node to the head of the linked list
/// @param head_ref The pointer to the linked list
/// @param value A value to add
void addFirst(struct Node** head_ref, int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Memory allocation failed.\n");
        return;
    }

    newNode->data = value;
    newNode->next = *head_ref;

    *head_ref = newNode;
}

/// @brief Adds a node to the end of the linked list
/// @param head_ref 
/// @param value 
void addLast(struct Node** head_ref, int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Memory allocation failed.\n");
        return;
    }

    newNode->data = value;
    newNode->next = NULL;

    if (*head_ref == NULL) {
        *head_ref = newNode;
        return;
    }

    struct Node* temp = *head_ref;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
}

/// @brief Adds a node after the given node
/// @param prevNode 
/// @param value 
void addAfter(struct Node* prevNode, int value) {
    if (prevNode == NULL) {
        printf("Previous node cannot be NULL.\n");
        return;
    }

    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Memory allocation failed.\n");
        return;
    }

    newNode->data = value;
    newNode->next = prevNode->next;

    prevNode->next = newNode;
}

/// @brief Get the first node in the list
/// @param head 
/// @return 
int getHead(struct Node* head) {
    if (head == NULL) {
        printf("List is empty.\n");
        return -1;
    }

    return head->data;
}

/// @brief Get the last node in the list
/// @param head the head node to get the list tail from the list
/// @return the value of the tail node
int getTail(struct Node* head) {
    if (head == NULL) {
        printf("List is empty.\n");
        return -1;
    }

    struct Node* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    return temp->data;
}

/// @brief Get a node by its index
/// @param index index of the node to retrieve
/// @return the value of the node to retrieve
int getNodeByIndex(struct Node* head, int index) {
    if (head == NULL) {
        printf("List is empty.\n");
        return -1;
    }

    struct Node* temp = head;
    int count = 0;
    while (temp != NULL) {
        if (count == index) {
            return temp->data;
        }
        temp = temp->next;
        count++;
    }

    printf("Index out of range.\n");
    return -1;
}

/// @brief Delete the first node in the list
/// @param head the head node of the list to delete the head node
void deleteFirst(struct Node** head_ref) {
    if (*head_ref == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* temp = *head_ref;
    *head_ref = (*head_ref)->next;
    free(temp);
}

/// @brief Delete the last node in the list
/// @param head the head node of the list to delete the last node
void deleteLast(struct Node** head_ref) {
    if (*head_ref == NULL) {
        printf("List is empty.\n");
        return;
    }

    if ((*head_ref)->next == NULL) {
        free(*head_ref);
        *head_ref = NULL;
        return;
    }

    struct Node* temp = *head_ref;
    struct Node* prev = NULL;

    while (temp->next != NULL) {
        prev = temp;
        temp = temp->next;
    }

    prev->next = NULL;
    free(temp);
}

/// @brief Delete a node by its value
/// @param value the value to delete
void deleteAtIndex(struct Node** head_ref, int index) {
    if (*head_ref == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* temp = *head_ref;

    if (index == 0) {
        *head_ref = temp->next;
        free(temp);
        return;
    }

    int count = 0;
    struct Node* prev = NULL;

    while (temp != NULL && count != index) {
        prev = temp;
        temp = temp->next;
        count++;
    }

    if (temp == NULL) {
        printf("Index out of range.\n");
        return;
    }

    prev->next = temp->next;
    free(temp);
}

/// @brief Delete a node by its index
/// @param index the index of the node to delete
void deleteAfterNode(struct Node* prevNode) {
    if (prevNode == NULL || prevNode->next == NULL) {
        printf("Invalid previous node.\n");
        return;
    }

    struct Node* temp = prevNode->next;
    prevNode->next = temp->next;
    free(temp);
}

void deleteByValue(struct Node** head_ref, int value) {
    if (*head_ref == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* temp = *head_ref;
    struct Node* prev = NULL;

    if (temp != NULL && temp->data == value) {
        *head_ref = temp->next;
        free(temp);
        return;
    }

    while (temp != NULL && temp->data != value) {
        prev = temp;
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Value not found in the list.\n");
        return;
    }

    prev->next = temp->next;
    free(temp);
}

/// @brief Update a node by its index
/// @param index the index of the node to update
/// @param value the new value to update
void updateByIndex(struct Node** head_ref, int index, int value) {
    if (*head_ref == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* temp = *head_ref;
    int count = 0;

    while (temp != NULL && count != index) {
        temp = temp->next;
        count++;
    }

    if (temp == NULL) {
        printf("Index out of range.\n");
        return;
    }

    temp->data = value;
}
