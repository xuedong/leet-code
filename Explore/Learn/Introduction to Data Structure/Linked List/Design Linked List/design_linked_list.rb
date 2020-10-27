class Node
    attr_accessor :val, :next
    def initialize(val)
        @val = val
        @next = nil
    end
end

class MyLinkedList

=begin
    Initialize your data structure here.
=end
    attr_accessor :head, :length
    def initialize()
        @length = 0
        @head = nil
    end


=begin
    Get the value of the index-th node in the linked list. If the index is invalid, return -1.
    :type index: Integer
    :rtype: Integer
=end
    def get(index)
        case
            when index < 0 then return -1
            when index == 0 then return @head.val
            when index >= @length then return -1
        else
            current = @head
            for i in 0..(index-1)
                current = current.next
            end
            return -1 if current.nil?
            return current.val
        end
    end


=begin
    Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    :type val: Integer
    :rtype: Void
=end
    def add_at_head(val)
        first = Node.new(val)
        first.next = @head
        @head = first
        @length += 1
    end


=begin
    Append a node of value val to the last element of the linked list.
    :type val: Integer
    :rtype: Void
=end
    def add_at_tail(val)
        last = Node.new(val)
        current = @head
        if @length == 0 then
            @head = last
            @length += 1
        else
            while !current.next.nil?
                current = current.next
            end
            current.next = last
            @length += 1
        end
    end


=begin
    Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
    :type index: Integer
    :type val: Integer
    :rtype: Void
=end
    def add_at_index(index, val)
        if index < 0 || index > @length
            return
        elsif index == 0
            add_at_head(val)
        elsif index == @length
            add_at_tail(val)
        else
            insert = Node.new(val)
            prev = @head
            for i in 0..(index-2)
                prev = prev.next
            end
            succ = prev.next
            prev.next = insert
            insert.next = succ
            @length += 1
        end
    end


=begin
    Delete the index-th node in the linked list, if the index is valid.
    :type index: Integer
    :rtype: Void
=end
    def delete_at_index(index)
        if index < 0 || index >= @length
            return
        elsif index == 0
            @head = @head.next
            @length -= 1
        else
            current = @head
            for i in 0..(index-2)
                current = current.next
            end
            return if current.next.nil?
            current.next = current.next.next
            @length += 1
        end
    end

        
end

# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList.new()
# param_1 = obj.get(index)
# obj.add_at_head(val)
# obj.add_at_tail(val)
# obj.add_at_index(index, val)
# obj.delete_at_index(index)
